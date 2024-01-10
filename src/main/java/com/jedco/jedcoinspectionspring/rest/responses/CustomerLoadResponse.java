package com.jedco.jedcoinspectionspring.rest.responses;

import java.math.BigDecimal;

public record CustomerLoadResponse(

        Long id,
        Long equipmentId,
        String equipment,
        BigDecimal powerRate,
        BigDecimal quantity,
        BigDecimal totalKwh
) {
}