package com.Practice.EmployeeManagement.Entity;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity

public class Projects {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID")
    private int projectId;

    @Column(name = "PROJECT_NAME", columnDefinition = "VARCHAR(100)")
    private String projectName;

    @Column(name = "PROJECT_OWNER", columnDefinition = "VARCHAR(100)")
    private String projectOwner;

    @Column(name = "START_DATE", columnDefinition = "DATE")
    private Date startDate;

    @Column(name = "END_DATE", columnDefinition = "DATE")
    private Date endDate;

    private boolean isActiveEmp;

    @ElementCollection
    @CollectionTable(name = "project_emp_skills", joinColumns = @JoinColumn(name = "project_id"))
    @Column(name = "skill")
    private List<String> empSkills;

    public Projects() {
		super();
		
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectOwner() {
		return projectOwner;
	}

	public void setProjectOwner(String projectOwner) {
		this.projectOwner = projectOwner;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isActiveEmp() {
		return isActiveEmp;
	}

	public void setActiveEmp(boolean isActiveEmp) {
		this.isActiveEmp = isActiveEmp;
	}

	public List<String> getEmpSkills() {
		return empSkills;
	}

	public void setEmpSkills(List<String> empSkills) {
		this.empSkills = empSkills;
	}

	
}
