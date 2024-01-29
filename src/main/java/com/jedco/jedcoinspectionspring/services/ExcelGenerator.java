package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.InspectionResponse;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;

import java.util.List;

public interface ExcelGenerator {
     byte[] generateExcel(List<InspectionResponse> inspections);
     byte[] generateSalesExcel(List<InspectionSalesResponse> inspections);
}
