package com.Practice.EmployeeManagement.Mapper;

import com.Practice.EmployeeManagement.Entity.Address;
import Dtos.AddressDto;

public class AddressMapper {

	public static Address toEntity(AddressDto dto) {
		if (dto == null)
			return null;

		Address address = new Address();
		address.setAddressLine1(dto.getAddressLine1());
		address.setAddressLine2(dto.getAddressLine2());
		return address;
	}

	public static AddressDto toDto(Address address) {
		if (address == null)
			return null;

		AddressDto dto = new AddressDto();
		dto.setAddressLine1(address.getAddressLine1());
		dto.setAddressLine2(address.getAddressLine2());
		return dto;
	}
}
