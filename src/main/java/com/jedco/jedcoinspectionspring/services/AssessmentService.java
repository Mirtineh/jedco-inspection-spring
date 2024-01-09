package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.LoadAssessmentInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.EquipmentResponse;
import com.jedco.jedcoinspectionspring.rest.responses.LoadAssessmentResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

import java.security.Principal;
import java.util.List;

public interface AssessmentService {
    List<EquipmentResponse> listAll();
    ResponseDTO insertAssessment(LoadAssessmentInsertRequest insertDto, String username);
    List<LoadAssessmentResponse> listAssessmentsByInspection(Long inspectionId);
}
