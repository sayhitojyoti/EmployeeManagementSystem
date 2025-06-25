package com.Practice.EmployeeManagement.Service;

import com.Practice.EmployeeManagement.Dao.EmployeeRepository;
import com.Practice.EmployeeManagement.Entity.Employee;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class PDFExportService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public byte[] exportEmployeesToPDFFile() throws IOException {
        List<Employee> employees = employeeRepository.findAll();

        Document document = new Document(PageSize.A4.rotate()); // Landscape A4
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

           
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16);
            Paragraph title = new Paragraph("Employee Details", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);

            // Table setup
            PdfPTable table = new PdfPTable(14);
            table.setWidthPercentage(100);

            Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
            String[] headers = {
                    "ID", "Name", "Age", "Skills", "Active", "State", "Country", "Pincode",
                    "Phone", "Project Name", "Project Owner", "Gender", "Email", "Salary"
            };

            for (String header : headers) {
                PdfPCell hCell = new PdfPCell(new Phrase(header, headFont));
                hCell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                table.addCell(hCell);
            }

            for (Employee emp : employees) {
                table.addCell(String.valueOf(emp.getId()));
                table.addCell(emp.getName());
                table.addCell(String.valueOf(emp.getAge()));
                table.addCell(emp.getSkills() != null ? String.join(", ", emp.getSkills()) : "");
                table.addCell(emp.isActive() ? "Yes" : "No");
                table.addCell(emp.getAddress() != null ? emp.getAddress().getState() : "");
                table.addCell(emp.getAddress() != null ? emp.getAddress().getCountry() : "");
                table.addCell(emp.getAddress() != null ? String.valueOf(emp.getAddress().getPincode()) : "");
                table.addCell(emp.getAddress() != null && emp.getAddress().getPhoneNumber() != null
                        ? emp.getAddress().getPhoneNumber().toString()
                        : "");
                table.addCell(emp.getProject() != null ? emp.getProject().getProjectName() : "");
                table.addCell(emp.getProject() != null ? emp.getProject().getProjectOwner() : "");
                table.addCell(emp.getDetails() != null ? emp.getDetails().getGender() : "");
                table.addCell(emp.getDetails() != null ? emp.getDetails().getEmail() : "");
                table.addCell(emp.getPayroll() != null ? String.valueOf(emp.getPayroll().getBasicSalary()) : "");
            }

            document.add(table);
            document.close();
        } catch (DocumentException ex) {
            throw new IOException("Error occurred while generating PDF", ex);
        }

        return out.toByteArray();
    }
}
