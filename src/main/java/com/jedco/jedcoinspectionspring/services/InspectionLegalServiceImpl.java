package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.Util.DateConverter;
import com.jedco.jedcoinspectionspring.Util.Day;
import com.jedco.jedcoinspectionspring.mappers.InspectionMapper;
import com.jedco.jedcoinspectionspring.models.*;
import com.jedco.jedcoinspectionspring.repositories.InspectionRepository;
import com.jedco.jedcoinspectionspring.repositories.SalesAssignmentRepository;
import com.jedco.jedcoinspectionspring.repositories.StatusRepository;
import com.jedco.jedcoinspectionspring.repositories.UserRepository;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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

    private final DateConverter dateConverter;
    private final InspectionMapper inspectionMapper;
    @Override
    public List<InspectionSalesResponse> legalInspectionsListByDate(String startDate, String endDate) {
        Long legalStatusId= 30L;
        Day day = dateConverter.convertBetweenDays(startDate, endDate);
        if (day == null) return null;
        List<Inspection> inspections = inspectionRepository.findAllByStatusIdGreaterThanAndRegisteredOnBetween(legalStatusId,day.startTime(),day.endTime());
        return inspections.stream().map(inspectionMapper::toInspectionSalesResponse).toList();

    }

    @Override
    public ResponseDTO updateInspectionStatus(Long inspectionId, Long statusId, String note, String username) {
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
        var user= optionalUser.get();
        var inspection= optionalInspection.get();
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


        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setActionDate(new Date());
        taskHistory.setInspection(inspection);
        taskHistory.setActionBy(user);
        taskHistory.setAdditionalNote(note);
        taskHistory.setActionType(status.getName().replace("-"," ").toUpperCase());
        taskHistory.setHistoryDetails(user.getFirstName()+" "+user.getLastName()+" Updated Inspection status to "+status.getName().replace("-"," "));

        this.asyncService.postHistory(taskHistory);


        return new ResponseDTO(true, "Inspection Status Updated Successfully!");

    }
}
