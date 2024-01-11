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
import com.jedco.jedcoinspectionspring.rest.requests.InspectionInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionCodesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionResponse;
import com.jedco.jedcoinspectionspring.rest.responses.PriorityResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    private final AsyncService asyncService;

    private final PriorityMapper priorityMapper;
    private final InspectionCodeMapper inspectionCodeMapper;
    private final InspectionMapper inspectionMapper;
    private final DateConverter dateConverter;
    @Override
    public ResponseDTO insertInspection(InspectionInsertRequest insertDto, String username) {
        try {

            TaskHistory taskHistory = new TaskHistory();

            Inspection inspection = new Inspection();

            Date regDate = new Date();

            User registeredBy = userRepository.findByUsername(username).get();
            Status registeredStatus = statusRepository.findById(10L).get();

            if(insertDto.meterNumber().isEmpty()){
                //TODO SET THE METERNUMBER TO EMPTY
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
            inspection.setMeterNo(insertDto.meterNumber());
            inspection.setCiuNo(insertDto.ciuNumber());
            inspection.setConnectionType(insertDto.connType());
            inspection.setTariffCategory(insertDto.tariffCat());
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

            System.out.println("ERROR registering Inspection -> " + ex.getMessage());
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
    public List<InspectionResponse> adminInspectionsListByDate(String startDate, String endDate, String username) {
        Day day = dateConverter.convertBetweenDays(startDate, endDate);
        if (day == null) return null;
        Long deletedStatus=3L;
        List<Inspection> inspections= inspectionRepository.findAllByStatusId_NotAndRegisteredOnBetween(deletedStatus,day.startTime(),day.endTime());
        return inspections.stream().map(inspectionMapper::toInspectionResponse).toList();
    }

    @Override
    public List<InspectionResponse> getInspectionsByDateAndStatus(String startDate, String endDate, Long statusId) {
        return null;
    }

    @Override
    public List<InspectionCodesResponse> inspectionCodesList(String meterType) {
        var inspectionCodes= inspectionCodeRepository.findAllByMeterType(meterType);
        return inspectionCodes.stream().map(inspectionCodeMapper::toResponse).toList();
    }

    @Override
    public ResponseDTO sendToSales(Long inspectionId, Long priorityId, String note, String username) {
        return null;
    }
}
