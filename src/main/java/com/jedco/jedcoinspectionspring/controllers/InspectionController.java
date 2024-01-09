package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.InspectionInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionCodesResponse;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionResponse;
import com.jedco.jedcoinspectionspring.rest.responses.PriorityResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.services.InspectionService;
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
@RequestMapping("/inspections")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Inspections")
public class InspectionController {
    private final InspectionService inspectionService;

    @GetMapping("/getPriorityLevels")
    public List<PriorityResponse> listAllPriorities() {
        return inspectionService.priorityList();
    }

    @GetMapping("/getInspectionCodes")
    public List<InspectionCodesResponse> getInspectionCodes(@RequestParam("meterType") String meterType) {
        return inspectionService.inspectionCodesList(meterType);
    }

    @PostMapping("/insertInspection")
    @PreAuthorize("hasAnyAuthority('REGISTER_INSPECTION')")
    public ResponseDTO register(InspectionInsertRequest insertDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.inspectionService.insertInspection(insertDto, userDetails.getUsername());
    }

    @GetMapping("/getInspectionSByDate")
    @PreAuthorize("hasAnyAuthority('VIEW_INSPECTION', 'REGISTER_INSPECTION', 'UPDATE_INSPECTION')")
    public List<InspectionResponse> getDailyInspectionS(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.inspectionService.inspectionsListByDate(startDate, endDate, userDetails.getUsername());
    }

    @GetMapping("/getAdminInspectionSByDate")
    @PreAuthorize("hasAnyAuthority('VIEW_INSPECTION', 'REGISTER_INSPECTION', 'UPDATE_INSPECTION')")
    public List<InspectionResponse> getAdminInspectionSByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.inspectionService.adminInspectionsListByDate(startDate, endDate, userDetails.getUsername());
    }

    @GetMapping("/sendInspectionsToSales")
    @PreAuthorize("hasAnyAuthority('VIEW_INSPECTION', 'REGISTER_INSPECTION', 'UPDATE_INSPECTION')")
    public ResponseDTO sendInspectionsToSales(@RequestParam("inspectionId") Long inspectionId, @RequestParam("priorityId") Long priorityId, @RequestParam("note") String note) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return this.inspectionService.sendToSales(inspectionId, priorityId, note, userDetails.getUsername());
    }

    @GetMapping("/getInspectionsByDateAndStatus")
    @PreAuthorize("hasAnyAuthority('VIEW_INSPECTION', 'REGISTER_INSPECTION', 'UPDATE_INSPECTION')")
    public List<InspectionResponse> getInspectionByDate(@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate, @RequestParam("statusId") Long statusId) {
        return this.inspectionService.getInspectionsByDateAndStatus(startDate, endDate, statusId);
    }

    //TODO implement this
//    @POST
//    @Path("/uploadFile")
//    @Consumes({"multipart/form-data"})
//    @Produces("application/json")
//    public ResponseDTO uploadFile(@MultipartForm FileUploadForm form) {
//        Principal principal = this.securityContext.getUserPrincipal();
//        return this.inspectionService.upload(form, principal);
//    }
}
