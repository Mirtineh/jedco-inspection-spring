package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.requests.PersonInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.PersonUpdateRequest;
import com.jedco.jedcoinspectionspring.rest.responses.PersonResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    @Override
    public List<PersonResponse> listAllPersons() {
        return null;
    }

    @Override
    public ResponseDTO registerPerson(PersonInsertRequest insertDto, String username) {
        return null;
    }

    @Override
    public ResponseDTO updateTeam(PersonUpdateRequest updateDto, String username) {
        return null;
    }

    @Override
    public ResponseDTO deletePerson(Long personId) {
        return null;
    }

    @Override
    public ResponseDTO suspendPerson(Long personId) {
        return null;
    }

    @Override
    public ResponseDTO reactivatePerson(Long personId) {
        return null;
    }

    @Override
    public List<PersonResponse> listAvailable() {
        return null;
    }
}
