package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.Util.DateConverter;
import com.jedco.jedcoinspectionspring.mappers.InspectionMapper;
import com.jedco.jedcoinspectionspring.mappers.QuotationMapper;
import com.jedco.jedcoinspectionspring.mappers.SalesAssessmentMapper;
import com.jedco.jedcoinspectionspring.models.*;
import com.jedco.jedcoinspectionspring.repositories.*;
import com.jedco.jedcoinspectionspring.rest.requests.QuotationInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.SalesAssessmentRegisterRequest;
import com.jedco.jedcoinspectionspring.rest.responses.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class InspectionSalesServiceImpl implements InspectionSalesService {
    private final InspectionRepository inspectionRepository;
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;
    private final SalesAssignmentRepository salesAssignmentRepository;
    private final SalesAssessmentRepository salesAssessmentRepository;
    private final QuotationRepository quotationRepository;

    private final AsyncService asyncService;
    private final PagingService pagingService;
    private final SalesAndLegalService salesAndLegalService;
    private final TaskHistoryService taskHistoryService;
    private final ExcelGenerator excelGenerator;
    private final DateConverter dateConverter;
    private final InspectionMapper inspectionMapper;
    private final SalesAssessmentMapper salesAssessmentMapper;
    private final QuotationMapper quotationMapper;

    @Value("${file.upload-dir}")
    private String uploadDir;
    @Override
    public SalesInspectionResponse salesInspectionsListByDate(String startDateString, String endDateString, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses, String problemType, int page, int limit, String sort) {
        Pageable pageable = pagingService.createPageable(page, limit, sort);
        Long salesStatusId=20L;
        Page<Inspection> inspectionPage=salesAndLegalService.getAllInspectionsData(salesStatusId,startDateString,endDateString,customerName,meterNumber, legalCaseNo, statuses,problemType,pageable);
        List<InspectionSalesResponse> inspectionResponses= inspectionPage.getContent().stream()
                .map(inspectionMapper::toInspectionSalesResponse).toList();
        Long totalRows = inspectionPage.getTotalElements();
        return new SalesInspectionResponse(inspectionResponses,totalRows);
    }
    @Override
    public ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String noteAdded, MultipartFile[] files, String username){
        Optional<Inspection> optionalInspection = inspectionRepository.findById(inspectionId);
        Optional<Status> optionalStatus = statusRepository.findById(statusId);

        if(username==null){
            return new ResponseDTO(false,"Login required!");
        }
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalInspection.isEmpty()){
            return new ResponseDTO(false, "Inspection Not Found!");
        }
        if(optionalStatus.isEmpty()){
            return new ResponseDTO(false, "Status Not Found!");
        }if(optionalUser.isEmpty()){
            return new ResponseDTO(false, "User Not Found!");
        }
        var inspection= optionalInspection.get();
        var status= optionalStatus.get();
        var user= optionalUser.get();
        inspection.setStatus(status);

        Optional<SalesAssignment> optionalAssignment = salesAssignmentRepository.findOneByInspectionId(inspectionId);
        if(optionalAssignment.isPresent()){
            var assignment= optionalAssignment.get();
            assignment.setStatus(status);
            salesAssignmentRepository.save(assignment);
        }

        inspection.setStatus(status);
        inspection.setUpdatedOn(new Date());


        inspectionRepository.save(inspection);

        String historyDetail=user.getFirstName()+" "+user.getLastName()+" Updated Inspection status to "+status.getName().replace("-"," ");
        String actionType=status.getName().replace("-"," ").toUpperCase();
        taskHistoryService.insertTaskHistory(inspection,noteAdded,user,actionType,historyDetail,"Sales_files",files);
        return new ResponseDTO(true, "Inspection Status Updated Successfully!");


    }

    @Override
    public ResponseDTO insertSalesAssessment(SalesAssessmentRegisterRequest insertDto, MultipartFile[] files, String username) {
        Optional<Inspection> optionalInspection = inspectionRepository.findById(insertDto.inspectionId());
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalInspection.isEmpty()){
            return new ResponseDTO(false, "Inspection Not Found!");
        }
        if(optionalUser.isEmpty()){
            return new ResponseDTO(false, "User Not Found!");
        }
        var inspection= optionalInspection.get();
        var user= optionalUser.get();
        SalesAssessment assessment = new SalesAssessment();
        assessment.setDistance(insertDto.distance());
        assessment.setInspection(inspection);
        assessment.setEasting(insertDto.easting());
        assessment.setNorthing(insertDto.northing());
        assessment.setRegisteredOn(new Date());
        assessment.setUser(user);
        assessment.setTxNo(insertDto.txNo());

        salesAssessmentRepository.save(assessment);
        inspection.setStatus(statusRepository.findById(24L).get());

        inspectionRepository.save(inspection);

        String actionType= "SALES ASSESSMENT SUBMITTED";
        String historyDetail= user.getFirstName()+" "+user.getLastName()+" Submitted Sales Assessment";
        taskHistoryService.insertTaskHistory(inspection,insertDto.note(),user,actionType,historyDetail,"Sales_files",files);

        return new ResponseDTO(true, "Sales Assessment Submitted Successfully!");

    }

    @Override
    public List<SalesAssessmentResponse> getSalesAssessment(Long inspectionId) {
        List<SalesAssessment> salesAssessments= salesAssessmentRepository.findAllByInspection_Id(inspectionId);
        return salesAssessments.stream().map(salesAssessmentMapper::toResponse).toList();
    }

    @Override
    public List<QuotationResponse> getQuotation(Long inspectionId) {
        List<Quotation> quotations = quotationRepository.findAllByInspection_Id(inspectionId);
        return quotations.stream().map(quotationMapper::toQuotationResponse).toList();
    }

    @Override
    public ResponseDTO insertQuotation(QuotationInsertRequest insertDto, MultipartFile[] files, String username) {
        Optional<Inspection> optionalInspection = inspectionRepository.findById(insertDto.inspectionId());
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalInspection.isEmpty()){
            return new ResponseDTO(false, "Inspection Not Found!");
        }
        if(optionalUser.isEmpty()){
            return new ResponseDTO(false, "User Not Found!");
        }
        var inspection= optionalInspection.get();
        var user= optionalUser.get();

        Quotation quotation = new Quotation();
        quotation.setQuotationRef(insertDto.quotationRef());
        quotation.setInspection(inspection);
        quotation.setAmount(insertDto.amount());
        quotation.setRegisteredOn(new Date());
        quotation.setUser(user);

        quotationRepository.save(quotation);
        inspection.setStatus(statusRepository.findById(27L).get());

        inspectionRepository.save(inspection);

        String actionType="QUOTATION SUBMITTED";
        String historyDetail=user.getFirstName()+" "+user.getLastName()+" Submitted Quotation";
        taskHistoryService.insertTaskHistory(inspection,insertDto.note(),user,actionType,historyDetail,"Sales_files",files);
        return new ResponseDTO(true, "Quotation Submitted Successfully!");
    }

    @Override
    public byte[] exportInspectionsToExcel(String startDateString, String endDateString, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses, String problemType, String sort) {
        Pageable pageable = pagingService.createPageable(sort);
        Long salesStatusId=20L;
        Page<Inspection> inspectionPage=salesAndLegalService.getAllInspectionsData(salesStatusId,startDateString,endDateString,customerName,meterNumber, legalCaseNo, statuses,problemType,pageable);
        List<InspectionSalesResponse> inspectionResponses= inspectionPage.getContent().stream()
                .map(inspectionMapper::toInspectionSalesResponse).toList();
        return excelGenerator.generateSalesExcel(inspectionResponses);
    }
}
