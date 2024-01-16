package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.mappers.PersonMapper;
import com.jedco.jedcoinspectionspring.models.Person;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.repositories.PersonRepository;
import com.jedco.jedcoinspectionspring.repositories.StatusRepository;
import com.jedco.jedcoinspectionspring.repositories.UserRepository;
import com.jedco.jedcoinspectionspring.rest.requests.PersonInsertRequest;
import com.jedco.jedcoinspectionspring.rest.requests.PersonUpdateRequest;
import com.jedco.jedcoinspectionspring.rest.responses.PersonResponse;
import com.jedco.jedcoinspectionspring.rest.responses.ResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final UserRepository userRepository;
    private final StatusRepository statusRepository;

    private final PersonMapper personMapper;

    @Override
    public List<PersonResponse> listAllPersons() {
        List<Person> personList = personRepository.findAll();
        return personList.stream().map(personMapper::toListAllPersonResponse).toList();
    }

    @Override
    public ResponseDTO registerPerson(PersonInsertRequest insertDto, String username) {
        try {

            Optional<User> optionalUser = userRepository.findByUsername(username);
            if (optionalUser.isEmpty()) {
                return new ResponseDTO(false, "User NOT Found!");
            }
            var user = optionalUser.get();
            Person person = new Person();
            person.setFirstName(insertDto.firstName());
            person.setLastName(insertDto.lastName());
            person.setStatus(statusRepository.findById(1L).get());
            person.setEmail(insertDto.email());
            person.setPhoneNo(insertDto.phoneNo());
            person.setRegisteredBy(user);
            person.setRegisterationDate(new Date());

            personRepository.save(person);
            return new ResponseDTO(true, "Person Registered Successfully!");


        } catch (Exception ex) {
            System.out.println("Person Registration Error => " + ex.getMessage());
            return new ResponseDTO(false, "Person Registration NOT Registered!");
        }
    }

    @Override
    public ResponseDTO updateTeam(PersonUpdateRequest updateDto, String username) {
        try {

            Optional<Person> optionalPerson = personRepository.findById(updateDto.id());
            if (optionalPerson.isEmpty()) {
                return new ResponseDTO(false, "Person NOT Found!");
            }
            var person = optionalPerson.get();
            Optional<User> optionalUser = userRepository.findByUsername(username);
            if (optionalUser.isEmpty()) {
                return new ResponseDTO(false, "User NOT Found!");
            }

            person.setFirstName(updateDto.firstName());
            person.setLastName(updateDto.lastName());
            person.setEmail(updateDto.email());
            person.setPhoneNo(updateDto.phoneNo());

            personRepository.save(person);

            //TODO activity Log
            //TODO team History
            //TODO person History

            return new ResponseDTO(true, "Person Updated Successfully!");

        } catch (Exception ex) {
            System.out.println("Person Update Error => " + ex.getMessage());
            return new ResponseDTO(false, "Person NOT Updated!");

        }
    }

    @Override
    public ResponseDTO deletePerson(Long personId) {
        try {
            Optional<Person> optionalPerson = personRepository.findById(personId);
            if (optionalPerson.isPresent() && optionalPerson.get().getStatus().getId().equals(1L)) {
                var person = optionalPerson.get();
                person.setStatus(statusRepository.findById(3L).get());
                person.setTerminationDate(new Date());
                personRepository.save(person);

                return new ResponseDTO(true, "Person Deleted Successfully!");
            }else if(optionalPerson.isPresent() && optionalPerson.get().getStatus().getId().equals(5L)){
                return new ResponseDTO(false, "Persons Assigned to a team can not be deleted!");
            }
            else {
                return new ResponseDTO(false, "Person NOT Found!");
            }

            //TODO activity Log
            //TODO team History
            //TODO person History


        } catch (Exception ex) {
            System.out.println("Person Delete Error => " + ex.getMessage());
            return new ResponseDTO(false, "Person NOT Deleted!");

        }
    }

    @Override
    public ResponseDTO suspendPerson(Long personId) {
        try {
            Optional<Person> optionalPerson = personRepository.findById(personId);
            if (optionalPerson.isPresent() && optionalPerson.get().getStatus().getId().equals(1L)) {
                var person = optionalPerson.get();
                person.setStatus(statusRepository.findById(4L).get());
                personRepository.save(person);

                return new ResponseDTO(true, "Person Suspended Successfully!");
            }else if(optionalPerson.isPresent() && optionalPerson.get().getStatus().getId().equals(5L)){
                return new ResponseDTO(false, "Persons Assigned to a team can not be suspended!");
            }
            else {
                return new ResponseDTO(false, "Person NOT Found!");
            }

            //TODO activity Log
            //TODO team History
            //TODO person History


        } catch (Exception ex) {
            System.out.println("Person Suspend Error => " + ex.getMessage());
            return new ResponseDTO(false, "Person NOT Suspended!");

        }
    }

    @Override
    public ResponseDTO reactivatePerson(Long personId) {
        try {
            Optional<Person> optionalPerson = personRepository.findById(personId);
            if(optionalPerson.isEmpty()){
                return new ResponseDTO(false, "Person NOT Found!");
            }
            var person = optionalPerson.get();

            if (person.getStatus().getId().equals(4L)) {
                person.setStatus(statusRepository.findById(1L).get());
                personRepository.save(person);
                return new ResponseDTO(true, "Person Reactivated Successfully!");
            } else {
                return new ResponseDTO(false, "Person NOT Found!");
            }
            //TODO activity Log
            //TODO team History
            //TODO person History

        } catch (Exception ex) {
            System.out.println("Person Suspend Error => " + ex.getMessage());
            return new ResponseDTO(false, "Person NOT Reactivated!");

        }
    }

    @Override
    public List<PersonResponse> listAvailable() {
        Long activeStatus = 1L;
        List<Person> personList = personRepository.findAllByStatus_Id(activeStatus);
        return personList.stream().map(personMapper::toAvailablePersonResponse).toList();
    }
}
