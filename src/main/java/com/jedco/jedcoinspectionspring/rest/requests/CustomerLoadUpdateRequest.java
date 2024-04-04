package com.jedco.jedcoinspectionspring.rest.requests;

import java.math.BigDecimal;

public record CustomerLoadUpdateRequest(
        Long id,
        Long equipmentId,
        BigDecimal powerRate,
        BigDecimal quantity,
        BigDecimal totalKwh
) {
}
