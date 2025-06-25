package com.Practice.EmployeeManagement.Mapper;

import com.Practice.EmployeeManagement.Entity.Employee;
import Dtos.EmployeeDto;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeDto employeeDto) {
        if (employeeDto == null) return null;

        Employee e = new Employee();
        e.setId(employeeDto.getId());
        e.setName(employeeDto.getName());
        e.setAge(employeeDto.getAge());
        e.setSkills(employeeDto.getSkills());
        e.setActive(employeeDto.isActive());
        e.setAddress(AddressMapper.toEntity(employeeDto.getAddressDto()));
 e.setProject(ProjectMapper.toEntity(employeeDto.getProjectDto()));
      
        return e;
    }

    public static EmployeeDto toDto(Employee e) {
        if (e == null) return null;

        EmployeeDto dto = new EmployeeDto();
        dto.setId(e.getId());
        dto.setName(e.getName());
        dto.setAge(e.getAge());
        dto.setSkills(e.getSkills());
        dto.setActive(e.isActive());
        dto.setAddressDto(AddressMapper.toDto(e.getAddress()));
 dto.setProjectDto(ProjectMapper.toDto(e.getProject()));
      
        return dto;
    }
}