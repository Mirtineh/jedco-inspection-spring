package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.Util.DateConverter;
import com.jedco.jedcoinspectionspring.Util.Day;
import com.jedco.jedcoinspectionspring.mappers.InspectionCodeMapper;
import com.jedco.jedcoinspectionspring.mappers.InspectionMapper;
import com.jedco.jedcoinspectionspring.mappers.PriorityMapper;
import com.jedco.jedcoinspectionspring.models.*;
import com.jedco.jedcoinspectionspring.repositories.*;
import com.jedco.jedcoinspectionspring.rest.requests.CheckListResultInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.CodeResultInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.FileUploadFormRequest;
import com.jedco.jedcoinspectionspring.rest.requests.InspectionInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InspectionServiceImpl implements InspectionService {
    private final PriorityRepository priorityRepository;
    private final InspectionCodeRepository inspectionCodeRepository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;
    private final InspectionRepository inspectionRepository;
    private final CheckListResultRepository checkListResultRepository;
    private final CheckListRepository checkListRepository;
    private final CodeResultRepository codeResultRepository;
    private final SalesAssignmentRepository salesAssignmentRepository;
    private final InspectionFileRepository inspectionFileRepository;
    private final AsyncService asyncService;
    private final ExcelGenerator excelGenerator;

    private final PriorityMapper priorityMapper;
    private final InspectionCodeMapper inspectionCodeMapper;
    private final InspectionMapper inspectionMapper;
    private final DateConverter dateConverter;
    @Value("${file.upload-dir}")
    private String uploadDir;
    @Override
    public ResponseDTO insertInspection(InspectionInsertRequest insertDto, String username) {
        try {

            TaskHistory taskHistory = new TaskHistory();

            Inspection inspection = new Inspection();

            Date regDate = new Date();

            User registeredBy = userRepository.findByUsername(username).get();
            Status registeredStatus = statusRepository.findById(10L).get();

            if(insertDto.metterNumber().isEmpty()){
                //TODO Check if this statement is necessary
//                insertDto.setMetterNumber("");
                if(insertDto.remark()==null || insertDto.remark().isEmpty()){
                    taskHistory.setAdditionalNote("Inspection Registered without Meter Number");
                }
            }
            else{
                taskHistory.setAdditionalNote(insertDto.remark());
            }

            Date registeredOn = new Date();

            inspection.setProblemTypes(insertDto.problemType());
            inspection.setMeterType(insertDto.meterType());
            inspection.setCustomerName(insertDto.customerName());
            inspection.setPhoneNo(insertDto.phoneNumber());
            inspection.setMeterNo(insertDto.metterNumber());
            inspection.setCiuNo(insertDto.ciuNumber());
            inspection.setConnectionType(insertDto.connType());
            inspection.setTariffCategory(insertDto.tarifCat());
            inspection.setLocation(insertDto.location());
            inspection.setFeeder(insertDto.feeder());
            inspection.setTxNo(insertDto.txNo());
            inspection.setLatitude(insertDto.latitude());
            inspection.setLongitude(insertDto.longitude());
            inspection.setLocationAccuracy(insertDto.locationAccuracy());
            inspection.setRegisteredOn(registeredOn);
            inspection.setUser(registeredBy);
            inspection.setCustomerSatisfactionReview(insertDto.customerSatisfactionReview());
            inspection.setRemark(insertDto.remark());
            inspection.setStatus(registeredStatus);
            inspection.setCustomerStatus(insertDto.customerStatus());

            inspectionRepository.save(inspection);

            for (CheckListResultInsertRequest checkListResult : insertDto.checkListResultList()) {
                CheckListResult result = new CheckListResult();
                CheckList checkList = checkListRepository.findById(checkListResult.checkListId()).get();

                result.setCheckList(checkList);
                result.setChecklistStatus(checkListResult.checklistStatus());
                result.setInspection(inspection);
                result.setRegisteredOn(registeredOn);
                result.setRemark(checkListResult.remark());
                result.setUser(registeredBy);

                checkListResultRepository.save(result);

            }

            for (CodeResultInsertRequest resultInsertDto : insertDto.codeResultList()) {
                CodeResult codeResult = new CodeResult();
                InspectionCode inspectionCode = inspectionCodeRepository.findById(resultInsertDto.inspectionCodeId()).get();

                codeResult.setInspectionCode(inspectionCode);
                codeResult.setInspection(inspection);
                codeResult.setRegisteredOn(registeredOn);
                codeResult.setUser(registeredBy);
                codeResult.setResult(resultInsertDto.result());

                codeResultRepository.save(codeResult);

            }


            taskHistory.setActionDate(regDate);
            taskHistory.setInspection(inspection);
            taskHistory.setActionBy(registeredBy);
            taskHistory.setActionType("INSPECTION REGISTERED");

            taskHistory.setHistoryDetails(registeredBy.getFirstName() + " " + registeredBy.getLastName() + " Registered the Inspection");


            this.asyncService.postHistory(taskHistory);


            return new ResponseDTO(true, "Inspection Registered Successfully!");
        } catch (Exception ex) {
            log.error("ERROR registering Inspection -> " + ex.getMessage());
            return new ResponseDTO(false, "Inspection NOT Registered");

        }
    }

    @Override
    public List<PriorityResponse> priorityList() {
        var priorities= priorityRepository.findAll();
        return priorities.stream().map(priorityMapper::toPriorityResponse).toList();
    }

    @Override
    public List<InspectionResponse> inspectionsListByDate(String startDate, String endDate, String username) {
        Day day = dateConverter.convertBetweenDays(startDate, endDate);
        if (day == null) return null;
        Long deletedStatus=3L;
        List<Inspection> inspections= inspectionRepository.findAllByStatusId_NotAndRegisteredOnBetween(deletedStatus,day.startTime(),day.endTime());
        return inspections.stream().map(inspectionMapper::toInspectionResponse).toList();

    }

    @Override
    public AdminInspectionResponse adminInspectionsListByDate(String startDateString, String endDateString,String customerName,String meterNumber,List<Long> statuses, int page, int limit,String sort) {
        Pageable pageable = createPageable(page, limit, sort);
        Page<Inspection> inspectionPage=getAllInspectionsData(startDateString,endDateString,customerName,meterNumber,statuses,pageable);
        List<InspectionResponse> inspectionResponses = inspectionPage.getContent().stream()
                .map(inspectionMapper::toInspectionResponse)
                .toList();
        Long totalRows = inspectionPage.getTotalElements();
        return new AdminInspectionResponse(inspectionResponses, totalRows);

    }
    private Page<Inspection> getAllInspectionsData(String startDateString, String endDateString, String customerName, String meterNumber, List<Long> statuses, Pageable pageable) {
        Day day = dateConverter.convertBetweenDays(startDateString, endDateString);
        Long deletedStatus=3L;
        Page<Inspection> inspectionPage;
        if(day!=null){
            if (statuses == null || statuses.isEmpty()) {
                if (customerName != null && meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(
                            deletedStatus, day.startTime(), day.endTime(), customerName, meterNumber, pageable);
                } else if (customerName != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCase(
                            deletedStatus, day.startTime(), day.endTime(), customerName, pageable);
                } else if (meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndRegisteredOnBetweenAndMeterNoContainingIgnoreCase(
                            deletedStatus, day.startTime(), day.endTime(), meterNumber, pageable);
                } else {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndRegisteredOnBetween(deletedStatus, day.startTime(), day.endTime(), pageable);
                }
            }
            else {
                if (customerName != null && meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(
                            deletedStatus, day.startTime(), day.endTime(), customerName, meterNumber, statuses, pageable);
                } else if (customerName != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndRegisteredOnBetweenAndCustomerNameContainingIgnoreCaseAndStatusIdIn(
                            deletedStatus, day.startTime(), day.endTime(), customerName, statuses, pageable);
                } else if (meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndRegisteredOnBetweenAndMeterNoContainingIgnoreCaseAndStatusIdIn(
                            deletedStatus, day.startTime(), day.endTime(), meterNumber, statuses, pageable);
                } else {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndRegisteredOnBetweenAndStatusIdIn(
                            deletedStatus, day.startTime(), day.endTime(), statuses, pageable);
                }
            }
        }
        else {
            if (statuses == null || statuses.isEmpty()) {
                if (customerName != null && meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCase(
                            deletedStatus, customerName, meterNumber, pageable);
                } else if (customerName != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndCustomerNameContainingIgnoreCase(
                            deletedStatus, customerName, pageable);
                } else if (meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndMeterNoContainingIgnoreCase(
                            deletedStatus, meterNumber, pageable);
                } else {
                    inspectionPage = inspectionRepository.findAllByStatusIdNot(deletedStatus, pageable);
                }
            }
            else {
                if (customerName != null && meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndCustomerNameContainingIgnoreCaseAndMeterNoContainingIgnoreCaseAndStatusIdIn(
                            deletedStatus, customerName, meterNumber, statuses, pageable);
                } else if (customerName != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndCustomerNameContainingIgnoreCaseAndStatusIdIn(
                            deletedStatus, customerName, statuses, pageable);
                } else if (meterNumber != null) {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndMeterNoContainingIgnoreCaseAndStatusIdIn(
                            deletedStatus, meterNumber, statuses, pageable);
                } else {
                    inspectionPage = inspectionRepository.findAllByStatusIdNotAndStatusIdIn(
                            deletedStatus, statuses, pageable);
                }
            }
        }
        return inspectionPage;
    }
    // Method to export data to Excel
    public byte[] exportInspectionsToExcel(String startDateString, String endDateString, String customerName, String meterNumber, List<Long> statuses, String sort) {
        Pageable pageable = createPageable(sort);
        Page<Inspection> inspectionPage=getAllInspectionsData(startDateString,endDateString,customerName,meterNumber,statuses,pageable);
        List<InspectionResponse> inspections = inspectionPage.getContent().stream()
                .map(inspectionMapper::toInspectionResponse)
                .toList();
        return excelGenerator.generateExcel(inspections);
    }

    private Pageable createPageable(String sort) {
        if (sort != null && !sort.isEmpty()) {
            String[] sortParts = sort.split("%");
            String sortBy = sortParts[0];
            Sort.Direction sortDirection = sortParts.length > 1 && sortParts[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

            // Create a mapping between request parameter names and entity fields
            Map<String, String> fieldMappings = Map.of(
                    "registeredDate", "registeredOn",
                    "metterNumber", "meterNo"
                    // Add more mappings as needed
            );

            // Use the mapping to get the actual field name
            String mappedField = fieldMappings.getOrDefault(sortBy, sortBy);

            return PageRequest.of(0, Integer.MAX_VALUE, Sort.by(sortDirection, mappedField));
        } else {
            return Pageable.unpaged();
        }
    }

    public Pageable createPageable(int page, int limit, String sort) {
            if (sort != null && !sort.isEmpty()) {
                String[] sortParts = sort.split("%");
                String sortBy = sortParts[0];
                Sort.Direction sortDirection = sortParts.length > 1 && sortParts[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;

                // Create a mapping between request parameter names and entity fields
                Map<String, String> fieldMappings = Map.of(
                        "registeredDate", "registeredOn",
                        "metterNumber", "meterNo"
                        // Add more mappings as needed
                );

                // Use the mapping to get the actual field name
                String mappedField = fieldMappings.getOrDefault(sortBy, sortBy);

                return PageRequest.of(page - 1, limit, Sort.by(sortDirection, mappedField));
            } else {
                return PageRequest.of(page - 1, limit);
            }
    }


    @Override
    public List<InspectionResponse> getInspectionsByDateAndStatus(String startDate, String endDate, Long statusId) {
        Day day = dateConverter.convertBetweenDays(startDate, endDate);
        if (day == null) return null;
        List<Inspection> inspections= inspectionRepository.findAllByStatusIdAndRegisteredOnBetween(statusId,day.startTime(),day.endTime());
        return inspections.stream().map(inspectionMapper::toInspectionResponse).toList();
    }

    @Override
    public List<InspectionCodesResponse> inspectionCodesList(String meterType) {
        var inspectionCodes= inspectionCodeRepository.findAllByMeterType(meterType);
        return inspectionCodes.stream().map(inspectionCodeMapper::toResponse).toList();
    }

    @Override
    public ResponseDTO sendToSales(Long inspectionId, Long priorityId, String note, String username) {
        try {

            Optional<Inspection> optionalInspection = inspectionRepository.findById(inspectionId);
            Status sentToSalesStatus = statusRepository.findById(20L).get();
            Optional<User> optionalUser = userRepository.findByUsername(username);
            Optional<Priority> optionalPriority = priorityRepository.findById(priorityId);

            Date date = new Date();
            if(optionalInspection.isEmpty()){
                return new ResponseDTO(false, "Inspection Not Found!");
            }
            if(optionalUser.isEmpty()){
                return new ResponseDTO(false, "User Not Found!");
            }if(optionalPriority.isEmpty()){
                return new ResponseDTO(false, "Priority Not Found!");
            }
            Inspection inspection= optionalInspection.get();
            var priority= optionalPriority.get();
            var user= optionalUser.get();
            SalesAssignment assignment = new SalesAssignment();
            assignment.setInspection(inspection);
            assignment.setPriority(priority);
            assignment.setStatus(sentToSalesStatus);
            assignment.setSalesSentDate(date);
            assignment.setUser(user);
            assignment.setNote(note);

            salesAssignmentRepository.save(assignment);

            inspection.setStatus(sentToSalesStatus);
            inspection.setUpdatedOn(date);

            TaskHistory taskHistory = new TaskHistory();
            taskHistory.setAdditionalNote(note);
            taskHistory.setActionDate(date);
            taskHistory.setInspection(inspection);
            taskHistory.setActionBy(user);
            taskHistory.setActionType("INSPECTION SENT TO SALES");
            taskHistory.setHistoryDetails(user.getFirstName() + " " + user.getLastName() + " Sent the Inspection to Sales");
            this.asyncService.postHistory(taskHistory);

            return new ResponseDTO(true, "Inspection Sent to Sales Successfully");
        }catch (Exception ex){
            log.error("Send Inspection to Sales Failed. "+ex.getMessage());
            return new ResponseDTO(false, "Send Inspection to Sales Failed.");

        }
    }

    @Override
    public ResponseDTO upload(FileUploadFormRequest form, String username) {
        try {
            Optional<User> optionalUser = userRepository.findByUsername(username);
            if (optionalUser.isEmpty()) {
                return new ResponseDTO(false, "User Not Found");
            }
            Optional<Inspection> optionalInspection = inspectionRepository.findById(form.inspectionId());
            if (optionalInspection.isEmpty()) {
                return new ResponseDTO(false, "Inspection Data Not Found");
            }
            var user= optionalUser.get();
            var inspection= optionalInspection.get();

//            String folder = System.getProperty("jboss.home.dir") + File.separator + "welcome-content";
            String folder = uploadDir;
            String path = File.separator + "inspectionFiles" + File.separator + inspection.getMeterNo();
            folder = folder + path;
            if (form.fileName() == null || form.fileName().isEmpty()) {
                return new ResponseDTO(false, "File Name Can not be empty!");
            }
            if (this.createFolderIfNotExists(folder)) {

                String filePath = path + File.separator + form.fileName();
                String fileName = folder + File.separator + form.fileName().replace("\\s", "_");

                if (this.writeFile(form.data(), fileName)) {
                    InspectionFile inspectionFile = new InspectionFile();
                    inspectionFile.setFileName(filePath);
                    inspectionFile.setFileUploadedOn(new Date());
                    inspectionFile.setUser(user);
                    inspectionFile.setInspection(inspection);
                    inspectionFile.setStatus(statusRepository.findById(1L).get());

                    inspectionFileRepository.save(inspectionFile);

                    TaskHistory taskHistory = new TaskHistory();

                    taskHistory.setActionDate(new Date());
                    taskHistory.setInspection(inspection);
                    taskHistory.setActionBy(user);
                    taskHistory.setActionType("PICTURE UPLOADED");

                    taskHistory.setHistoryDetails(user.getFirstName() + " " + user.getLastName() + " Uploaded Inspection Picture");


                    this.asyncService.postHistory(taskHistory);

                    return new ResponseDTO(true, "File Uploaded Successfully");
                } else {
                    return new ResponseDTO(false, "A file with the same name already exists!");
                }
            } else {
                return new ResponseDTO(false, "Unable to create folder!");
            }

        } catch (Exception var5) {
            log.error(var5.getMessage());
            return new ResponseDTO(false, "File Upload Failed!");
        }
    }
    private boolean createFolderIfNotExists(String dirName) throws SecurityException {
        File theDir = new File(dirName);
        log.info(dirName);
        if (!theDir.exists()) {
            log.info("the path not exists");
            return theDir.mkdirs();
        } else {
            log.info("the path exists");
            return true;
        }

    }
    private boolean writeFile(MultipartFile content, String filename) throws IOException {
        try {
            File file = new File(filename);
            if (file.exists()) {
                return false;
            }
            content.transferTo(file);
            return true;
        } catch (IOException e) {
            log.error(e.getMessage());
            return false;
        }
    }
}
