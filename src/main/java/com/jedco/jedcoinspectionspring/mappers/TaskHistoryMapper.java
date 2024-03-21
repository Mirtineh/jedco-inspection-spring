package com.jedco.jedcoinspectionspring.mappers;

import com.jedco.jedcoinspectionspring.models.TaskHistory;
import com.jedco.jedcoinspectionspring.models.UploadedFile;
import com.jedco.jedcoinspectionspring.models.User;
import com.jedco.jedcoinspectionspring.rest.responses.TaskHistoryResponse;
import com.jedco.jedcoinspectionspring.rest.responses.UploadedFileResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskHistoryMapper {
    @Mapping(target = "fileResponseList", source = "uploadedFiles")
    @Mapping(target = "teamName", ignore = true)
    @Mapping(target = "teamLeader", ignore = true)
    @Mapping(target = "teamId", ignore = true)
    @Mapping(target = "taskId", source = "id")
    @Mapping(target = "actionDetails", source = "historyDetails")
    @Mapping(target = "actionByName", source = "actionBy", qualifiedByName = "mapRegisteredBy")
    @Mapping(target = "actionById", source = "actionBy.id")
    TaskHistoryResponse toResponse(TaskHistory taskHistory);


    UploadedFileResponse toUploadFileResponse(UploadedFile uploadedFile);

    @Named("mapRegisteredBy")
    default String mapRegisteredBy (User user){
        return user.getFirstName()+" "+user.getLastName();
    }
}
