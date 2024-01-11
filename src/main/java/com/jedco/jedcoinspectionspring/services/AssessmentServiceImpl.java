package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.AssessmentMapper;
import com.jedco.jedcoinspectionspring.mappers.EquipmentMapper;
import com.jedco.jedcoinspectionspring.models.*;
import com.jedco.jedcoinspectionspring.repositories.*;
import com.jedco.jedcoinspectionspring.rest.requests.CustomerLoadInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.LoadAssessmentInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.EquipmentResponse;
import com.jedco.jedcoinspectionspring.rest.responses.LoadAssessmentResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {
    private final EquipmentRepository equipmentRepository;
    private final InspectionAssessmentRepository assessmentRepository;
    private final UserRepository userRepository;
    private final InspectionRepository inspectionRepository;
    private final StatusRepository statusRepository;
    private final CustomerLoadRepository customerLoadRepository;
    private final EquipmentMapper equipmentMapper;
    private final AssessmentMapper assessmentMapper;
    @Override
    public List<EquipmentResponse> listAll() {
        var equipments = equipmentRepository.findAll();
        return equipments.stream().map(equipmentMapper::toEquipmentResponse).toList();
    }

    @Override
    public ResponseDTO insertAssessment(LoadAssessmentInsertRequest insertDto, String username) {
        Optional<Inspection> optionalInspection = inspectionRepository.findById(insertDto.inspectionId());
        Optional<User> optionalRegisteredBy = userRepository.findByUsername(username);
        if(optionalInspection.isEmpty()){
            return new ResponseDTO(false, "Inspection Not Found.");
        }
        if(optionalRegisteredBy.isEmpty()){
            return new ResponseDTO(false, "User Not Found.");
        }
        Inspection inspection= optionalInspection.get();
        User registeredBy= optionalRegisteredBy.get();
        Date regDate = new Date();
        Status activeStatus = statusRepository.findById(1L).get();

        InspectionAssessment assessment = new InspectionAssessment();
        assessment.setInspection(inspection);
        assessment.setCustomerType(insertDto.customerType());
        assessment.setPresentedDocument(insertDto.presentedDocument());
        assessment.setReason(insertDto.reason());
        assessment.setRegisteredOn(regDate);
        assessment.setUser(registeredBy);
        assessment.setStatus(activeStatus);

        assessmentRepository.save(assessment);

        for (CustomerLoadInsertRequest loadInsertDto : insertDto.customerLoadInsertDto()) {
            CustomerLoad customerLoad = new CustomerLoad();
            Equipment equipments = equipmentRepository.findById(loadInsertDto.equipmentId()).get();

            customerLoad.setEquipment(equipments);
            customerLoad.setInspectionAssesment(assessment);
            customerLoad.setPowerRate(loadInsertDto.powerRate());
            customerLoad.setQuantity(loadInsertDto.quantity());
            customerLoad.setTotalKwh(loadInsertDto.totalKwh());
            customerLoad.setRegisteredOn(regDate);
            customerLoad.setUser(registeredBy);
            customerLoad.setStatus(activeStatus);

            customerLoadRepository.save(customerLoad);

        }


        TaskHistory taskHistory = new TaskHistory();

        taskHistory.setActionDate(regDate);
        taskHistory.setInspection(inspection);
        taskHistory.setActionBy(registeredBy);
        taskHistory.setActionType("INSPECTION ASSESSMENT SUBMITTED");

        taskHistory.setHistoryDetails(registeredBy.getFirstName() + " " + registeredBy.getLastName() + " Submitted Inspection Assessment");

        return new ResponseDTO(true, "Assessment Registered Successfully.");


    }

    @Override
    public List<LoadAssessmentResponse> listAssessmentsByInspection(Long inspectionId) {
        var assessment= assessmentRepository.findFirstByInspection_Id(inspectionId);
        return Collections.singletonList(assessmentMapper.toLoadAssessmentResponse(assessment));

    }
}
