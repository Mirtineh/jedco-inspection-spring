package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.responses.ProblemTypeResponse;
import com.jedco.jedcoinspectionspring.services.ProblemTypeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/problemTypes")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "ProblemTypes")
public class ProblemTypeController {
    private final ProblemTypeService problemTypeService;

    @GetMapping("/getAllProblemTypes")
    public List<String> listAll() {
        return problemTypeService.listAll();
    }

    @GetMapping("/getProblemTypes")
    public List<ProblemTypeResponse> getProblemTypes() {
        return problemTypeService.getProblemTypes();
    }
}
