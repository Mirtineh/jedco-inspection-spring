package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.Util.DateConverter;
import com.jedco.jedcoinspectionspring.mappers.InspectionMapper;
import com.jedco.jedcoinspectionspring.models.*;
import com.jedco.jedcoinspectionspring.repositories.InspectionRepository;
import com.jedco.jedcoinspectionspring.repositories.SalesAssignmentRepository;
import com.jedco.jedcoinspectionspring.repositories.StatusRepository;
import com.jedco.jedcoinspectionspring.repositories.UserRepository;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.SalesInspectionResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class InspectionLegalServiceImpl implements InspectionLegalService {
    private final InspectionRepository inspectionRepository;
    private final StatusRepository statusRepository;
    private final UserRepository userRepository;
    private final SalesAssignmentRepository salesAssignmentRepository;
    private final AsyncService asyncService;
    private final SalesAndLegalService salesAndLegalService;
    private final TaskHistoryService taskHistoryService;
    private final PagingService pagingService;
    private final ExcelGenerator excelGenerator;

    private final DateConverter dateConverter;
    private final InspectionMapper inspectionMapper;
    @Override
    public SalesInspectionResponse legalInspectionsListByDate(String startDateString, String endDateString, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses, String problemType, int page, int limit, String sort) {
        Pageable pageable = pagingService.createPageable(page, limit, sort);
        Long salesStatusId=30L;
        Page<Inspection> inspectionPage=salesAndLegalService.getAllInspectionsData(salesStatusId,startDateString,endDateString,customerName,meterNumber,legalCaseNo,statuses,problemType,pageable);
        List<InspectionSalesResponse> inspectionResponses= inspectionPage.getContent().stream()
                .map(inspectionMapper::toInspectionSalesResponse).toList();
        Long totalRows = inspectionPage.getTotalElements();
        return new SalesInspectionResponse(inspectionResponses,totalRows);

    }

    @Override
    public ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String note, String legalCaseNo, MultipartFile[] files, String username) {
        Optional<Inspection> optionalInspection = inspectionRepository.findById(inspectionId);
        Optional<Status> optionalStatus = statusRepository.findById(statusId);

//        if(principal.getName()==null){
//            return new ResponseDTO(false,"Login required!");
//        }
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalInspection.isEmpty()){
            return new ResponseDTO(false, "Inspection Not Found!");
        }
        if(optionalStatus.isEmpty()){
            return new ResponseDTO(false, "Status Not Found!");
        }if(optionalUser.isEmpty()){
            return new ResponseDTO(false, "User Not Found!");
        }
        var status=optionalStatus.get();
        long caseOpenedStatus= 32L;
        if(status.getId().equals(caseOpenedStatus) && (legalCaseNo == null || legalCaseNo.isEmpty())){
            return new ResponseDTO(false,"Case Number Can not be empty!");
        }
        var user= optionalUser.get();
        var inspection= optionalInspection.get();
        inspection.setStatus(status);
        if(status.getId().equals(caseOpenedStatus)){
            inspection.setLegalCaseNo(legalCaseNo);
        }

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
        taskHistoryService.insertTaskHistory(inspection,note,user,actionType,historyDetail,"Legal_files",files);

        return new ResponseDTO(true, "Inspection Status Updated Successfully!");

    }

    @Override
    public byte[] exportInspectionsToExcel(String startDateString, String endDateString, String customerName, String meterNumber, String legalCaseNo, List<Long> statuses, String problemType, String sort) {
        Pageable pageable = pagingService.createPageable(sort);
        Long salesStatusId=30L;
        Page<Inspection> inspectionPage=salesAndLegalService.getAllInspectionsData(salesStatusId,startDateString,endDateString,customerName,meterNumber, legalCaseNo, statuses,problemType,pageable);
        List<InspectionSalesResponse> inspectionResponses= inspectionPage.getContent().stream()
                .map(inspectionMapper::toInspectionSalesResponse).toList();
        return excelGenerator.generateSalesExcel(inspectionResponses);
    }
}
