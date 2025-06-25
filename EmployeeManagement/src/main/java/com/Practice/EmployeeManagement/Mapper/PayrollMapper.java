package com.Practice.EmployeeManagement.Mapper;

import com.Practice.EmployeeManagement.Entity.Payroll;

import Dtos.PayrollDto;


public class PayrollMapper {

    // Convert Entity to DTO
    public static PayrollDto toDto(Payroll payroll) {
        if (payroll == null) {
            return null;
        }
        PayrollDto dto = new PayrollDto();
        dto.setBasicSalary(payroll.getBasicSalary());
        dto.setBonus(payroll.getBonus());
        dto.setDeductions(payroll.getDeductions());
        dto.setNetPay(payroll.getNetPay());
        return dto;
    }

    // Convert DTO to Entity
    public static Payroll toEntity(PayrollDto dto) {
        if (dto == null) {
            return null;
        }
        Payroll payroll = new Payroll();
        payroll.setBasicSalary(dto.getBasicSalary());
        payroll.setBonus(dto.getBonus());
        payroll.setDeductions(dto.getDeductions());
        payroll.setNetPay(dto.getNetPay());
        return payroll;
    }
}
