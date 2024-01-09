package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.UpdateInspectionStatusRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.services.InspectionLegalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/legal")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Legal")
public class LegalController {
    private final InspectionLegalService legalService;

    @GetMapping("/getLegalInspectionSByDate")
    @PreAuthorize("hasAnyAuthority('VIEW_INSPECTION', 'REGISTER_INSPECTION', 'UPDATE_INSPECTION','UPDATE_INSPECTION_IN_LEGAL','VIEW_INSPECTION_IN_LEGAL')")
    public List<InspectionSalesResponse> getSalesInspectionSByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        return this.legalService.legalInspectionsListByDate(startDate, endDate);
    }

    @PostMapping("/updateInspectionStatus")
    public ResponseDTO updateInspectionStatus(@RequestBody UpdateInspectionStatusRequest dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.legalService.updateInspectionStatus(dto.inspectionId(),dto.statusId(), dto.note(), userDetails.getUsername());
    }
}
