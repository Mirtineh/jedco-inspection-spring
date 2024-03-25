package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.UpdateInspectionStatusRequest;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.rest.responses.SalesInspectionResponse;
import com.jedco.jedcoinspectionspring.services.InspectionLegalService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public SalesInspectionResponse getLegalInspectionSByDate(
            @RequestParam(value = "startDate",required = false) String startDate,
            @RequestParam(value = "endDate",required = false) String endDate,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "20") Integer limit,
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "metterNumber", required = false) String meterNumber,
            @RequestParam(value = "legalCaseNo", required = false) String legalCaseNo,
            @RequestParam(value = "statuses", required = false) List<Long> statuses,
            @RequestParam(value = "sort", required = false) String sort
    ) {
        return this.legalService.legalInspectionsListByDate(startDate, endDate, customerName,meterNumber,legalCaseNo,statuses, page,limit,sort);
    }

    @GetMapping("/exportLegalToExcel")
    public ResponseEntity<byte[]> exportInspectionsToExcel(
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "meterNumber", required = false) String meterNumber,
            @RequestParam(value = "legalCaseNo", required = false) String legalCaseNo,
            @RequestParam(value = "statuses", required = false) List<Long> statuses,
            @RequestParam(value = "sort", required = false) String sort
    ) {
        byte[] excelData = legalService.exportInspectionsToExcel(startDate, endDate, customerName, meterNumber,legalCaseNo, statuses, sort);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        headers.setContentDispositionFormData("attachment", "inspections.xlsx");
        headers.setContentLength(excelData.length);
        return new ResponseEntity<>(excelData, headers, HttpStatus.OK);
    }

    @PostMapping("/updateInspectionStatus")
    public ResponseDTO updateInspectionStatus(@RequestParam("inspectionId") Long inspectionId,
                                              @RequestParam("statusId") Long statusId,
                                              @RequestParam(value = "noteAdded",required = false) String noteAdded,
                                              @RequestParam(value = "legalCaseNo",required = false) String legalCaseNo,
                                              @RequestParam(value = "files",required = false) MultipartFile[] files
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.legalService.updateInspectionStatus(inspectionId,statusId, noteAdded,legalCaseNo,files, userDetails.getUsername());
    }
}
