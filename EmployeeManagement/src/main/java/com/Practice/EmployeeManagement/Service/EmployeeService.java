package com.Practice.EmployeeManagement.Service;

import java.io.IOException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
//import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.Practice.EmployeeManagement.Dao.EmployeeRepository;
import com.Practice.EmployeeManagement.Entity.Employee;
import com.Practice.EmployeeManagement.Mapper.EmployeeMapper;

import Dtos.EmployeeDto;
import Dtos.SearchDto;
import jakarta.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private RestTemplate  restTemplate;
//	@Scheduled(cron="* */5 * * * *")
	//===============================================
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	public List<Employee> getEmployeesByName(String name) {
		return employeeRepository.findByNameIgnoreCase(name);
	}

	public List<Employee> getEmployeesByAge(int age) {
		return employeeRepository.findByAge(age);
	}
	//========================================UPDATE EMPLOYEE LOGIC==============================================================//
	public Employee updateEmployee(Long id, EmployeeDto dto) {
	    Optional<Employee> emp = employeeRepository.findById(id);
	    if (emp.isPresent()) {
	        Employee e = emp.get();
	        e.setName(dto.getName());
	        e.setAge(dto.getAge());
	        e.setSkills(dto.getSkills());
	        return employeeRepository.save(e);
	    } else {
	        throw new EntityNotFoundException("Employee ID " + id + " not found");
	    }
	}

	//=====================================DELETE EMPLOYEE LOGIC=================================================================//

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
	//===================================SAVE EMPLOYEE LOGIC===================================================================//


	public Employee saveEmployee(EmployeeDto employeeDto) {
		Employee empDo = new Employee();

		empDo = EmployeeMapper.toEntity(employeeDto);
		

		return employeeRepository.save(empDo);
	}

	//=======================================SEARCH EMPLOYEE LOGIC===============================================================//
	public List<EmployeeDto> searchEmployees(SearchDto searchDto) {
		@SuppressWarnings("removal")
		Specification<Employee> spec = Specification.where(null);

		if (searchDto.getId() != null) {
			spec = spec.and((root, query, cb) -> cb.equal(root.get("id"), searchDto.getId()));
		}

		if (isNotEmpty(searchDto.getName())) {
			spec = spec.and(likeIgnoreCase("name", searchDto.getName()));
		}

		if (searchDto.getAge() != null) {
			spec = spec.and((root, query, cb) -> cb.equal(root.get("age"), searchDto.getAge()));
		}

		if (isNotEmpty(searchDto.getSkill())) {
			spec = spec.and(likeIgnoreCase("skills", searchDto.getSkill()));
		}

		if (isNotEmpty(searchDto.getGender())) {
			spec = spec.and(equalIgnoreCase("gender", searchDto.getGender()));
		}

		if (searchDto.getIsActive() != null) {
			spec = spec.and((root, query, cb) -> cb.equal(root.get("active"), searchDto.getIsActive()));
		}

		return employeeRepository.findAll(spec).stream().map(EmployeeMapper::toDto).collect(Collectors.toList());
	}

	private boolean isNotEmpty(String value) {
		return value != null && !value.trim().isEmpty();
	}

	private Specification<Employee> likeIgnoreCase(String field, String value) {
		return (root, query, cb) -> cb.like(cb.lower(root.get(field)), "%" + value.toLowerCase() + "%");
	}

	private Specification<Employee> equalIgnoreCase(String field, String value) {
		return (root, query, cb) -> cb.equal(cb.lower(root.get(field)), value.toLowerCase());
	}
	
	//==========================================UPLOAD FILE LOGIC============================================================//
	
	public void saveFile(MultipartFile file) throws IOException {
	    Employee emp = new Employee();
	    emp.setFileName(file.getOriginalFilename());
	    emp.setFileType(file.getContentType());
	    emp.setFileData(file.getBytes());
	    employeeRepository.save(emp);
	}
	
	//========================================= DOWNLOAD THAT UPLOADED FILE LOGIC=============================================================//
	
	public Employee getFileByFileName(String fileName) {
	    return employeeRepository.findByFileName(fileName)
	            .orElseThrow(() -> new RuntimeException("File not found with name: " + fileName));
	}

	//===========================GeoLocationAPI====================
	 public Map<String, String> getLocationFromIP() {
	        String url = "http://ip-api.com/json/";

	        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
	        JSONObject json = new JSONObject(response.getBody());

	        Map<String, String> location = new HashMap<>();
	        location.put("lat", String.valueOf(json.getDouble("lat")));
	        location.put("lon", String.valueOf(json.getDouble("lon")));

	        return location;
	    }
	//============================Weather API =========================
	public String fetchData() {
		String url = "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={apikey}";

        Map<String, String> location = getLocationFromIP();

        Map<String, String> Variables = new HashMap<>();
        Variables.put("lat", location.get("lat"));
       Variables.put("lon", location.get("lon"));
        Variables.put("apikey", "xxxxxxxxxxxxxxxxxxxxxx"); 

        try {
            return restTemplate.getForObject(url, String.class, Variables);
        } catch (HttpClientErrorException e) {
            System.err.println("API call failed: " + e.getStatusCode() + " - " + e.getResponseBodyAsString());
            return "API Error: " + e.getStatusCode();
        }
	}
}

    


