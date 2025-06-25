package com.Practice.EmployeeManagement.Mapper;

import com.Practice.EmployeeManagement.Entity.Projects;

import Dtos.ProjectsDto;



public class ProjectMapper {

    public static Projects toEntity(ProjectsDto dto) {
        if (dto == null) return null;

        Projects project = new Projects();
        project.setProjectId(dto.getProjectId());
        project.setProjectName(dto.getProjectName());
        project.setProjectOwner(dto.getProjectOwner());
        project.setStartDate(dto.getStartDate());
        project.setEndDate(dto.getEndDate());
        return project;
    }

    public static ProjectsDto toDto(Projects project) {
        if (project == null) return null;

        ProjectsDto dto = new ProjectsDto();
        dto.setProjectId(project.getProjectId());
        dto.setProjectName(project.getProjectName());
        dto.setProjectOwner(project.getProjectOwner());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        return dto;
    }
}
