package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.PersonInsertRequest;
import com.jedco.jedcoinspectionspring.rest.responses.PersonResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;

import java.security.Principal;
import java.util.List;

public interface PersonService {
    public List<PersonResponse> listAllPersons();
    public ResponseDTO registerPerson(PersonInsertRequest insertDto, String username);
    public ResponseDTO deletePerson(Long personId);
    public ResponseDTO suspendPerson(Long personId);
    public ResponseDTO reactivatePerson(Long personId);
    public List<PersonResponse> listAvailable();
}
