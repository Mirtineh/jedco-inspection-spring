package com.jedco.jedcoinspectionspring.services;

import com.jedco.jedcoinspectionspring.rest.responses.InspectionResponse;
import com.jedco.jedcoinspectionspring.rest.responses.InspectionSalesResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelGeneratorImpl implements ExcelGenerator {
    @Override
    public byte[] generateExcel(List<InspectionResponse> inspections) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Inspections");

            // Create a bold font
            Font boldFont = workbook.createFont();
            boldFont.setBold(true);

            // Create a cell style with the bold font
            CellStyle boldStyle = workbook.createCellStyle();
            boldStyle.setFont(boldFont);
            // Create header row
            Row headerRow = sheet.createRow(0);
            createCell(headerRow, 0, "Customer Name",boldStyle);
            createCell(headerRow, 1, "Phone Number",boldStyle);
            createCell(headerRow, 2, "Meter Number",boldStyle);
            createCell(headerRow, 3, "Problem Type",boldStyle);
            createCell(headerRow, 4, "Registered on",boldStyle);
            createCell(headerRow, 5, "Status",boldStyle);
            createCell(headerRow, 6, "Location",boldStyle);
            createCell(headerRow, 7, "Tariff Category",boldStyle);
            createCell(headerRow, 8, "Connection Type",boldStyle);
            createCell(headerRow, 9, "Feeder",boldStyle);
            createCell(headerRow, 10, "Tx No.",boldStyle);
            createCell(headerRow, 11, "Customer Status",boldStyle);
            // Add more headers as needed

            // Populate data rows
            int rowNum = 1;
            for (InspectionResponse inspection : inspections) {
                Row row = sheet.createRow(rowNum++);
                createCell(row, 0, inspection.customerName(),null);
                createCell(row, 1, inspection.phoneNumber(),null);
                createCell(row, 2, inspection.metterNumber(),null);
                createCell(row, 3, inspection.problemType(),null);
                createCell(row, 4, String.valueOf(inspection.registeredDate()),null);
                createCell(row, 5, inspection.status(),null);
                createCell(row, 6, inspection.location(),null);
                createCell(row, 7, inspection.tarifCat(),null);
                createCell(row, 8, inspection.connType(),null);
                createCell(row, 9, inspection.feeder(),null);
                createCell(row, 10, inspection.txNo(),null);
                createCell(row, 11, inspection.customerStatus(),null);
                // Add more data as needed
            }

            // Write the workbook content to a ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception appropriately
            return new byte[0];
        }
    }

    @Override
    public byte[] generateSalesExcel(List<InspectionSalesResponse> inspections) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Inspections");

            // Create a bold font
            Font boldFont = workbook.createFont();
            boldFont.setBold(true);

            // Create a cell style with the bold font
            CellStyle boldStyle = workbook.createCellStyle();
            boldStyle.setFont(boldFont);
            // Create header row
            Row headerRow = sheet.createRow(0);
            createCell(headerRow, 0, "Customer Name",boldStyle);
            createCell(headerRow, 1, "Phone Number",boldStyle);
            createCell(headerRow, 2, "Meter Number",boldStyle);
            createCell(headerRow, 3, "Problem Type",boldStyle);
            createCell(headerRow, 4, "Registered on",boldStyle);
            createCell(headerRow, 5, "Status",boldStyle);
            createCell(headerRow, 6, "Location",boldStyle);
            createCell(headerRow, 7, "Tariff Category",boldStyle);
            createCell(headerRow, 8, "Connection Type",boldStyle);
            createCell(headerRow, 9, "Feeder",boldStyle);
            createCell(headerRow, 10, "Tx No.",boldStyle);
            createCell(headerRow, 11, "Customer Status",boldStyle);
            // Add more headers as needed

            // Populate data rows
            int rowNum = 1;
            for (InspectionSalesResponse inspection : inspections) {
                Row row = sheet.createRow(rowNum++);
                createCell(row, 0, inspection.customerName(),null);
                createCell(row, 1, inspection.phoneNumber(),null);
                createCell(row, 2, inspection.metterNumber(),null);
                createCell(row, 3, inspection.problemType(),null);
                createCell(row, 4, String.valueOf(inspection.registeredDate()),null);
                createCell(row, 5, inspection.status(),null);
                createCell(row, 6, inspection.location(),null);
                createCell(row, 7, inspection.tarifCat(),null);
                createCell(row, 8, inspection.connType(),null);
                createCell(row, 9, inspection.feeder(),null);
                createCell(row, 10, inspection.txNo(),null);
                createCell(row, 11, inspection.customerStatus(),null);
                // Add more data as needed
            }

            // Write the workbook content to a ByteArrayOutputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);

            return outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception appropriately
            return new byte[0];
        }
    }

    private static void createCell(Row row, int columnIndex, String value,CellStyle style) {
        Cell cell = row.createCell(columnIndex);
        cell.setCellValue(value);
        cell.setCellStyle(style);
    }
}
