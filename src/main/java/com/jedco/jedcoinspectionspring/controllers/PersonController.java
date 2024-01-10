package com.jedco.jedcoinspectionspring.controllers;

import com.jedco.jedcoinspectionspring.rest.requests.PersonInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.PersonUpdateRequest;
import com.jedco.jedcoinspectionspring.rest.responses.PersonResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import com.jedco.jedcoinspectionspring.services.PersonService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
@SecurityRequirement(name = "Bearer Authentication")
@Tag(name = "Persons")
public class PersonController {
    private final PersonService personService;

    @GetMapping("/getAllPersons")
    public List<PersonResponse> listAll() {
        return personService.listAllPersons();
    }

    @GetMapping("/getAvailablePersons")
    public List<PersonResponse> getAvailablePersons() {
        return personService.listAvailable();
    }

    @PostMapping("/insertPerson")
    public ResponseDTO register(@RequestBody PersonInsertRequest insertDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return personService.registerPerson(insertDto, userDetails.getUsername());
    }

    @PutMapping("/updatePerson")
    public ResponseDTO update(@RequestBody PersonUpdateRequest updateDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return personService.updateTeam(updateDto, userDetails.getUsername());
    }

    @DeleteMapping("/deletePerson")
    public ResponseDTO delete(@RequestParam("personId") Long personId) {
        return personService.deletePerson(personId);
    }

    @GetMapping("/suspendPerson")
    public ResponseDTO suspend(@RequestParam("personId") Long personId) {
        return personService.suspendPerson(personId);
    }

    @GetMapping("/reactivatePerson")
    public ResponseDTO reactivate(@RequestParam("personId") Long personId) {
        return personService.reactivatePerson(personId);
    }
}
