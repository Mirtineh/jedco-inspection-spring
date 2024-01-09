package com.jedco.jedcoinspectionspring.rest.requests;

public record CheckListResultInsertRequest(
        Long checkListId,
        boolean checklistStatus,
        String remark
) {
}
