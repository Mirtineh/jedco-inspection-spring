package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.Date;

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
        Date actionDate
) {
}
