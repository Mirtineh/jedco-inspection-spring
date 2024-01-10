package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.Date;

public record CheckListResultResponse(
        Long id,
        Long checkListId,
        String checkList,
        boolean checklistStatus,
        String remark,
        Date registeredOn,
        Date updatedOn
) {
}
