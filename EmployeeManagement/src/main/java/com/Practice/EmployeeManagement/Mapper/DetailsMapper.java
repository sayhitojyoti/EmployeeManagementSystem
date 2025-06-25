package com.Practice.EmployeeManagement.Mapper;

import com.Practice.EmployeeManagement.Entity.Details;

import Dtos.DetailsDto;


public class DetailsMapper {

    // Convert Entity to DTO
    public static DetailsDto toDto(Details details) {
        if (details == null) {
            return null;
        }
        DetailsDto dto = new DetailsDto();
        dto.setGender(details.getGender());
        dto.setEmail(details.getEmail());
        return dto;
    }

    // Convert DTO to Entity
    public static Details toEntity(DetailsDto dto) {
        if (dto == null) {
            return null;
        }
        Details details = new Details();
        details.setGender(dto.getGender());
        details.setEmail(dto.getEmail());
        return details;
    }
}
