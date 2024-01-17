package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.responses.ConfirmCustomerResponse;
import com.jedco.jedcoinspectionspring.services.ConfirmCustomerService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/conlogService")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "ConlogService")
public class WebserviceController {
    private final ConfirmCustomerService confirmCustomerService;

    @PostMapping("/confirmCustomer")
    @PreAuthorize("hasAnyAuthority('REGISTER_INSPECTION')")
    public ConfirmCustomerResponse confirmCustomer(@RequestParam("meterNumber")String meterNumber){
        return this.confirmCustomerService.confirmCustomer(meterNumber);
    }
}
