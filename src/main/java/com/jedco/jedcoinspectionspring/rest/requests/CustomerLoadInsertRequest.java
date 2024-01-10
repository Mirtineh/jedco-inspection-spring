package com.jedco.jedcoinspectionspring.rest.requests;

import java.math.BigDecimal;

public record CustomerLoadInsertRequest(
        Long equipmentId,
        BigDecimal powerRate,
        BigDecimal quantity,
        BigDecimal totalKwh
) {
}
