package com.jedco.jedcoinspectionspring.rest.responses;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record CheckListResultResponse(
        Long id,
        Long checkListId,
        String checkList,
        boolean checklistStatus,
        String remark,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date registeredOn,
        @JsonFormat(shape = JsonFormat.Shape.NUMBER)
        Date updatedOn
) {
}
