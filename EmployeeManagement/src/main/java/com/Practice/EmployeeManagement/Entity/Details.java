package com.Practice.EmployeeManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Details {
	@Column(name = "GENDER", columnDefinition = "VARCHAR(100)")
	private String gender;
	@Column(name = "EMAIL", columnDefinition = "VARCHAR(100)")
	private String email;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
