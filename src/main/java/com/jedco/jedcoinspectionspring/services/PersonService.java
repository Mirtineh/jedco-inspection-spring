package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.PersonInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.PersonResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

import java.util.List;

public interface PersonService {
    List<PersonResponse> listAllPersons();

    ResponseDTO registerPerson(PersonInsertRequest insertDto, String username);

    ResponseDTO deletePerson(Long personId);

    ResponseDTO suspendPerson(Long personId);

    ResponseDTO reactivatePerson(Long personId);

    List<PersonResponse> listAvailable();
}
