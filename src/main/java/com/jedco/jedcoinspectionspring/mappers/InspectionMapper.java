package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.*;
import com.jedco.jedcoinspectionspring.rest.responses.CheckListResultResponse;
import com.jedco.jedcoinspectionspring.rest.responses.CodeResultResponse;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface InspectionMapper {
    @Mapping(target = "tarifCat", source = "tariffCategory")
    @Mapping(target = "statusId", source = "status.id")
    @Mapping(target = "status", source = "status.name")
    @Mapping(target = "registeredDate", source = "registeredOn")
    @Mapping(target = "registeredBy", source = "user", qualifiedByName = "mapRegisteredBy")
    @Mapping(target = "problemType", source = "problemTypes")
    @Mapping(target = "phoneNumber", source = "phoneNo")
    @Mapping(target = "metterNumber", source = "meterNo")
    @Mapping(target = "connType", source = "connectionType")
    @Mapping(target = "completedDate", source = "completedOn")
    @Mapping(target = "ciuNumber", source = "ciuNo")
    @Mapping(target = "approvedDate", source = "approvedOn")
    @Mapping(target = "codeResultList", source = "codeResults")
    @Mapping(target = "checkListResultList", source = "installationChecklists")
    @Mapping(target = "filePath", source = "inspectionFiles", qualifiedByName = "mapFilePath")
    @Mapping(target = "assesmentSubmitted", source = "assessments", qualifiedByName = "mapAssessments")
    InspectionResponse toInspectionResponse(Inspection inspection);
    @Named("mapRegisteredBy")
    default String mapRegisteredBy (User user){
        return user.getFirstName()+" "+user.getLastName();
    }

    @Named("mapFilePath")
    default String mapFilePath(Set<InspectionFile> inspectionFiles){
        if(inspectionFiles==null){
            return "";
        }
        return inspectionFiles.iterator().next().getFileName();
    }

    @Named("mapAssessments")
    default boolean mapAssessments(Set<InspectionAssessment> assessments){
        return assessments != null;
    }


    @Mapping(target = "checkListId", source = "id")
    @Mapping(target = "checkList",source = "checkList.checkList")
    CheckListResultResponse toCheckListResultResponse(CheckListResult checkListResult);

    @Mapping(target = "inspectionCodeId", source = "inspectionCode.id")
    @Mapping(target = "description", source = "inspectionCode.description")
    @Mapping(target = "inspectionCode",source = "inspectionCode.code")
    CodeResultResponse toCodeResultResponse(CodeResult codeResult);



}
