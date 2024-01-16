package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.InspectionTeam;
import com.jedco.jedcoinspectionspring.models.Person;
import com.jedco.jedcoinspectionspring.repositories.InspectionTeamRepository;
import com.jedco.jedcoinspectionspring.rest.responses.PersonResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class PersonMapper {
    @Autowired
    InspectionTeamRepository inspectionTeamRepository;
    @Mapping(target = "teamName",constant = "")
    @Mapping(target = "statusId", ignore = true)
    public abstract PersonResponse toAvailablePersonResponse(Person person);

    @Mapping(target = "teamName", source = "teamId", qualifiedByName = "mapTeamName")
    @Mapping(target = "statusId", ignore = true)
    public abstract PersonResponse toListAllPersonResponse(Person person);

    @Named("mapTeamName")
    protected String mapTeamName(Long teamId){
        Optional<InspectionTeam> optionalInspectionTeam= inspectionTeamRepository.findById(teamId);
        return optionalInspectionTeam.map(InspectionTeam::getTeamName).orElse(null);
    }
}
