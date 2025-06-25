package com.Practice.EmployeeManagement.Entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMP_ID")
	private int id;

	private String name;

	private int age;


	@ElementCollection
	@CollectionTable(name = "employee_skills", joinColumns = @JoinColumn(name = "emp_id"))
	@Column(name = "skill")
	private List<String> skills;

	private boolean isActive;

	@Embedded
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private Projects project;

	@Embedded
	private Details details;

	private Payroll payroll;

	@Lob
	@Column(name = "file_data")
	private byte[] fileData;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "file_type")
	private String fileType;
	



	public byte[] getFileData() {
		return fileData;
	}

	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}

	public Details getDetails() {
		return details;
	}

	public void setDetails(Details details) {
		this.details = details;
	}

	public Payroll getPayroll() {
		return payroll;
	}

	public void setPayroll(Payroll payroll) {
		this.payroll = payroll;
	}

}
