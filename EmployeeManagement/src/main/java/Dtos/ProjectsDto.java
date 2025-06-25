package Dtos;

import java.util.Date;

import java.util.List;

public class ProjectsDto {
	private String projectName;
	public ProjectsDto() {
		super();
		
	}
	private int projectId;
	private String projectOwner;
    private Date startDate;
    private Date endDate;
    private boolean isActiveEmp;
    private List<String> empSkills;
    
    
	
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
