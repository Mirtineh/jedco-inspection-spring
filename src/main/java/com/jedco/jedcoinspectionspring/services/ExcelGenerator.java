package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.InspectionResponse;

import java.util.List;

public interface ExcelGenerator {
     byte[] generateExcel(List<InspectionResponse> inspections);
}
