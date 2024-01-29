package com.jedco.jedcoinspectionspring.rest.responses;

import java.util.List;

public record SalesInspectionResponse(List<InspectionSalesResponse> response, Long totalRows) {
}
