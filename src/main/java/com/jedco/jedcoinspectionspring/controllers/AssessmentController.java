package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.LoadAssessmentInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.EquipmentResponse;
import com.jedco.jedcoinspectionspring.rest.responses.LoadAssessmentResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.services.AssessmentService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assessment")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Assessment")
public class AssessmentController {
    private final AssessmentService assessmentService;

    @GetMapping("/listEquipments")
    public List<EquipmentResponse> listEquipments() {
        return assessmentService.listAll();
    }

    @GetMapping("/listAssessmentsByInspection")
    public List<LoadAssessmentResponse> listAssessmentsByInspection(@RequestParam("inspectionId") Long inspectionId) {
        return assessmentService.listAssessmentsByInspection(inspectionId);
    }

    @PostMapping("/registerLoadAssesment")
    public ResponseDTO registerLoadAssessment(@RequestBody LoadAssessmentInsertRequest insertDto) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return assessmentService.insertAssessment(insertDto, userDetails.getUsername());
    }


}
