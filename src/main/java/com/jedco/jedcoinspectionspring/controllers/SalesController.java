package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.QuotationInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.SalesAssessmentRegisterRequest;
import com.jedco.jedcoinspectionspring.rest.responses.*;
import com.jedco.jedcoinspectionspring.services.InspectionSalesService;
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
@RequestMapping("/sales")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "SalesAndMarketing")
public class SalesController {
    private final InspectionSalesService inspectionSalesService;

    @GetMapping("/getSalesInspectionSByDate")
    @PreAuthorize("hasAnyAuthority('VIEW_INSPECTION', 'REGISTER_INSPECTION', 'UPDATE_INSPECTION')")
    public SalesInspectionResponse getSalesInspectionSByDate(
            @RequestParam(value = "startDate",required = false) String startDate,
            @RequestParam(value = "endDate",required = false) String endDate,
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "limit", defaultValue = "20") Integer limit,
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "metterNumber", required = false) String meterNumber,
            @RequestParam(value = "statuses", required = false) List<Long> statuses,
            @RequestParam(value = "sort", required = false) String sort
    ) {
        return inspectionSalesService.salesInspectionsListByDate(startDate, endDate, customerName,meterNumber,statuses, page,limit,sort);
    }
    @GetMapping("/exportSalesToExcel")
    public ResponseEntity<byte[]> exportInspectionsToExcel(
            @RequestParam(value = "startDate", required = false) String startDate,
            @RequestParam(value = "endDate", required = false) String endDate,
            @RequestParam(value = "customerName", required = false) String customerName,
            @RequestParam(value = "meterNumber", required = false) String meterNumber,
            @RequestParam(value = "statuses", required = false) List<Long> statuses,
            @RequestParam(value = "sort", required = false) String sort
    ) {
        byte[] excelData = inspectionSalesService.exportInspectionsToExcel(startDate, endDate, customerName, meterNumber, statuses, sort);
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
                                              @RequestParam(value = "files",required = false) MultipartFile[] files
                                              ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return inspectionSalesService.updateInspectionStatus(inspectionId, statusId, noteAdded,files, userDetails.getUsername());
    }

    @GetMapping("/getSalesAssessmentList")
    public List<SalesAssessmentResponse> getSalesAssessmentList(@RequestParam("inspectionId") Long inspectionId) {
        return this.inspectionSalesService.getSalesAssessment(inspectionId);
    }

    @PostMapping(value = "/insertSalesAssessment")
    public ResponseDTO insertSalesAssessment(@RequestParam("inspectionId") Long inspectionId,
                                             @RequestParam("txNo") String txNo,
                                             @RequestParam("distance") Double distance,
                                             @RequestParam("northing") Double northing,
                                             @RequestParam("easting") Double easting,
                                             @RequestParam(value = "note", required = false) String note,
                                             @RequestParam(value = "files",required = false) MultipartFile[] files) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        var insertDto= new SalesAssessmentRegisterRequest(inspectionId,txNo,distance,northing,easting,note);
        return this.inspectionSalesService.insertSalesAssessment(insertDto,files, userDetails.getUsername());
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
