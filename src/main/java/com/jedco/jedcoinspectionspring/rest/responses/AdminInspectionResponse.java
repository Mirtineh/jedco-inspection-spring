package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.List;

public record AdminInspectionResponse(List<InspectionResponse> response, Long totalRows) {
}
