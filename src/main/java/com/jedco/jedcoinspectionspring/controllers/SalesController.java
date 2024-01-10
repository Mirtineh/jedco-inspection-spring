package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.QuotationInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.SalesAssessmentRegisterRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.QuotationResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.SalesAssessmentResponse;
import com.jedco.jedcoinspectionspring.services.InspectionSalesService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "SalesAndMarketing")
public class SalesController {
    private final InspectionSalesService inspectionSalesService;

    @GetMapping("/getSalesInspectionSByDate")
    @PreAuthorize("hasAnyAuthority('VIEW_INSPECTION', 'REGISTER_INSPECTION', 'UPDATE_INSPECTION')")
    public List<InspectionSalesResponse> getSalesInspectionSByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return inspectionSalesService.salesInspectionsListByDate(startDate, endDate);
    }

    @GetMapping("/updateInspectionStatus")
    public ResponseDTO updateInspectionStatus(@RequestParam("inspectionId") Long inspectionId, @RequestParam("statusId") Long statusId, @RequestParam("noteAdded") String noteAdded) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return inspectionSalesService.updateInspectionStatus(inspectionId, statusId, noteAdded, userDetails.getUsername());
    }

    @GetMapping("/getSalesAssessmentList")
    public List<SalesAssessmentResponse> getSalesAssessmentList(@RequestParam("inspectionId") Long inspectionId) {
        return this.inspectionSalesService.getSalesAssessment(inspectionId);
    }

    @PostMapping("/insertSalesAssessment")
    public ResponseDTO insertSalesAssessment(@RequestBody SalesAssessmentRegisterRequest insertDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.inspectionSalesService.insertSalesAssessment(insertDto, userDetails.getUsername());
    }

    @GetMapping("/getQuotationList")
    public List<QuotationResponse> getQuotationList(@RequestParam("inspectionId") Long inspectionId) {
        return inspectionSalesService.getQuotation(inspectionId);
    }

    @PostMapping("/insertQuotation")
    public ResponseDTO insertQuotation(@RequestBody QuotationInsertRequest insertDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return inspectionSalesService.insertQuotation(insertDto, userDetails.getUsername());
    }
}
