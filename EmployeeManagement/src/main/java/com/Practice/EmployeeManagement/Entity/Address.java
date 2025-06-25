package com.Practice.EmployeeManagement.Entity;

import jakarta.persistence.Column;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	

	@Column(name = "CURRENT_ADDRESS", columnDefinition = "VARCHAR(1000)")
	private String addressLine1;

	@Column(name = "PERMANENT_ADDRESS", columnDefinition = "VARCHAR(1000)")
	private String addressLine2;

	@Column(name = "STATE", columnDefinition = "VARCHAR(100)")
	private String state;

	@Column(name = "COUNTRY", columnDefinition = "VARCHAR(100)")
	private String country;

	@Column(name = "PINCODE", columnDefinition = "VARCHAR(6)")
	private int pincode;

	@Column(name = "PHONE_NUMBER", columnDefinition = "VARCHAR(15)")
	private Long phoneNumber;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	

	

}
