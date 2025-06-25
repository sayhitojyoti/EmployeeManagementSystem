package com.Practice.EmployeeManagement.Service;

import com.Practice.EmployeeManagement.Dao.EmployeeRepository;
import com.Practice.EmployeeManagement.Entity.Employee;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelExportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public byte[] exportEmployeesToExcelFile() throws IOException {
        List<Employee> employees = employeeRepository.findAll();

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet("Employees");
            int rowIdx = 0;

            Row headerRow = sheet.createRow(rowIdx++);
            headerRow.createCell(0).setCellValue("ID");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Age");
            headerRow.createCell(3).setCellValue("Skills");
            headerRow.createCell(4).setCellValue("Active");
            headerRow.createCell(5).setCellValue("State");
            headerRow.createCell(6).setCellValue("Country");
            headerRow.createCell(7).setCellValue("Pincode");
            headerRow.createCell(8).setCellValue("Phone");
            headerRow.createCell(9).setCellValue("Project Name");
            headerRow.createCell(10).setCellValue("Project Owner");
            headerRow.createCell(11).setCellValue("Gender");
            headerRow.createCell(12).setCellValue("Email");
            headerRow.createCell(13).setCellValue("Salary");

            for (Employee emp : employees) {
                Row row = sheet.createRow(rowIdx++);
                row.createCell(0).setCellValue(emp.getId());
                row.createCell(1).setCellValue(emp.getName());
                row.createCell(2).setCellValue(emp.getAge());
                row.createCell(3).setCellValue(emp.getSkills() != null ? String.join(", ", emp.getSkills()) : "");
                row.createCell(4).setCellValue(emp.isActive());
                row.createCell(5).setCellValue(emp.getAddress() != null ? emp.getAddress().getState() : "");
                row.createCell(6).setCellValue(emp.getAddress() != null ? emp.getAddress().getCountry() : "");
                row.createCell(7).setCellValue(emp.getAddress() != null ? emp.getAddress().getPincode() : 0);
                row.createCell(8).setCellValue(emp.getAddress() != null && emp.getAddress().getPhoneNumber() != null
                        ? emp.getAddress().getPhoneNumber()
                        : 0);
                row.createCell(9).setCellValue(emp.getProject() != null ? emp.getProject().getProjectName() : "");
                row.createCell(10).setCellValue(emp.getProject() != null ? emp.getProject().getProjectOwner() : "");
                row.createCell(11).setCellValue(emp.getDetails() != null ? emp.getDetails().getGender() : "");
                row.createCell(12).setCellValue(emp.getDetails() != null ? emp.getDetails().getEmail() : "");
                row.createCell(13).setCellValue(emp.getPayroll() != null ? emp.getPayroll().getBasicSalary() : 0);
            }

            for (int i = 0; i <= 13; i++) {
                sheet.autoSizeColumn(i);
            }

          
            String filePath = "C:\\Users\\jyoti.nayak\\Downloads\\employees.xlsx";
            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
                System.out.println("Excel file saved at: " + filePath);
            }
        }
		return null;
    }

} 