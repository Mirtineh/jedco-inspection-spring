package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.PersonInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.PersonUpdateRequest;
import com.jedco.jedcoinspectionspring.rest.responses.PersonResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

import java.security.Principal;
import java.util.List;

public interface PersonService {
    List<PersonResponse> listAllPersons();

    ResponseDTO registerPerson(PersonInsertRequest insertDto, String username);
    ResponseDTO updateTeam(PersonUpdateRequest updateDto, String username);

    ResponseDTO deletePerson(Long personId);

    ResponseDTO suspendPerson(Long personId);

    ResponseDTO reactivatePerson(Long personId);

    List<PersonResponse> listAvailable();
}
