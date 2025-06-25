package Dtos;

import java.util.List;

import jakarta.persistence.Entity;
@Entity
public class EmployeeDto {

	

	public EmployeeDto() {
		super();
	
	}
	private int id;
	private String name;

	private int age;

	private List<String> skills;

	private boolean isActive;

	private AddressDto addressDto;

	private ProjectsDto projectDto;

	private DetailsDto detailsDto;

	private PayrollDto payrollDto;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public AddressDto getAddressDto() {
		return addressDto;
	}

	public void setAddressDto(AddressDto addressDto) {
		this.addressDto = addressDto;
	}

	public ProjectsDto getProjectDto() {
		return projectDto;
	}

	public void setProjectDto(ProjectsDto projectDto) {
		this.projectDto = projectDto;
	}

	public DetailsDto getDetailsDto() {
		return detailsDto;
	}

	public void setDetailsDto(DetailsDto detailsDto) {
		this.detailsDto = detailsDto;
	}

	public PayrollDto getPayrollDto() {
		return payrollDto;
	}

	public void setPayrollDto(PayrollDto payrollDto) {
		this.payrollDto = payrollDto;
	}


}
