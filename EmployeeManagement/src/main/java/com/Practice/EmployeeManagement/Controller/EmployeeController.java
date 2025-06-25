package com.Practice.EmployeeManagement.Controller;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.Practice.EmployeeManagement.Dao.EmployeeRepository;
import com.Practice.EmployeeManagement.Entity.Employee;
import com.Practice.EmployeeManagement.Mapper.EmployeeMapper;
import com.Practice.EmployeeManagement.Service.EmployeeService;
import com.Practice.EmployeeManagement.Service.ExcelExportService;
import com.Practice.EmployeeManagement.Service.PDFExportService;

import Dtos.EmployeeDto;
import Dtos.SearchDto;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ExcelExportService excelExportService;
	@Autowired
	private PDFExportService pdfExportService;
	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}

	@PostMapping("/saveEmployee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.saveEmployee(employee));
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
		Optional<Employee> employee = employeeService.getEmployeeById(id);
		return employee.map(e -> ResponseEntity.ok(EmployeeMapper.toDto(e)))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		return ResponseEntity.ok(employeeService.getAllEmployees());
	}

	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto employeeDto) {
	    Employee updated = employeeService.updateEmployee(id, employeeDto);
	    return ResponseEntity.ok(updated);
	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/employees/byname")
	public ResponseEntity<?> getEmployeesByName(@RequestParam String name) {
		return ResponseEntity.ok(employeeService.getEmployeesByName(name));
	}

	@GetMapping("/employees/byage")
	public ResponseEntity<?> getEmployeesByAge(@RequestParam int age) {
		return ResponseEntity.ok(employeeService.getEmployeesByAge(age));
	}

	@PostMapping("/searchEmployee")
	public ResponseEntity<List<EmployeeDto>> searchEmployee(@RequestBody(required = false) SearchDto searchDto,
			@RequestParam(required = false) Integer id, @RequestParam(required = false) String name,
			@RequestParam(required = false) Integer age, @RequestParam(required = false) String gender,
			@RequestParam(required = false) String skill, @RequestParam(required = false) Boolean isactive) {
		if (searchDto == null) {
			searchDto = new SearchDto();
			searchDto.setId(id);
			searchDto.setName(name);
			searchDto.setAge(age);
			searchDto.setGender(gender);
			searchDto.setSkill(skill);
			searchDto.setIsActive(isactive);
		}

		List<EmployeeDto> results = employeeService.searchEmployees(searchDto);

		if (results.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(results);
	}

	@GetMapping("/employees/export")
	public ResponseEntity<byte[]> exportEmployeesToExcel() throws IOException {
		byte[] excelBytes = excelExportService.exportEmployeesToExcelFile();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employees.xlsx");
		headers.set(HttpHeaders.CONTENT_TYPE, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

		return ResponseEntity.ok().headers(headers).body(excelBytes);
	}

	@GetMapping("/employees/export/pdf")
	public ResponseEntity<byte[]> exportEmployeesToPdf() throws IOException {
		byte[] pdfBytes = pdfExportService.exportEmployeesToPDFFile();

		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employees.pdf");
		headers.set(HttpHeaders.CONTENT_TYPE, "application/pdf");

		return ResponseEntity.ok().headers(headers).body(pdfBytes);
	}

	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		try {

			return ResponseEntity.ok("File uploaded successfully!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
		}
	}

	@GetMapping("/download")
	public ResponseEntity<byte[]> downloadFile(@RequestParam String filename) {
		Optional<Employee> employeeOptional = employeeRepository.findByFileName(filename);

		if (employeeOptional.isPresent()) {
			Employee emp = employeeOptional.get();

			return ResponseEntity.ok().contentType(MediaType.parseMediaType(emp.getFileType()))
					.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + emp.getFileName() + "\"")
					.body(emp.getFileData());
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/fetchWeatherData")
	public ResponseEntity<String> fetchEmployees() {
		String data = employeeService.fetchData();
		return ResponseEntity.ok(data);
	}

}
