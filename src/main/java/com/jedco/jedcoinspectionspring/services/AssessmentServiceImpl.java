package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.LoadAssessmentInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.EquipmentResponse;
import com.jedco.jedcoinspectionspring.rest.responses.LoadAssessmentResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AssessmentServiceImpl implements AssessmentService {
    @Override
    public List<EquipmentResponse> listAll() {
        return null;
    }

    @Override
    public ResponseDTO insertAssessment(LoadAssessmentInsertRequest insertDto, String username) {
        return null;
    }

    @Override
    public List<LoadAssessmentResponse> listAssessmentsByInspection(Long inspectionId) {
        return null;
    }
}
