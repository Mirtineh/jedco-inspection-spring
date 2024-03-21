package com.jedco.jedcoinspectionspring.rest.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public record TaskHistoryResponse(
        String id,
        String taskId,
        Long actionById,
        String actionByName,
        String actionType,
        String actionDetails,
        String additionalNote,
        String teamId,
        String teamName,
        String teamLeader,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date actionDate,
        List<UploadedFileResponse> fileResponseList
) {
}
