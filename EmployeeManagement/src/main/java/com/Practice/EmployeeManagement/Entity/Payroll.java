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
public class Payroll {
	@Column(name = "SALARY", columnDefinition = "VARCHAR(100)")
	private double basicSalary;
	@Column(name = "BONUS", columnDefinition = "VARCHAR(100)")
	private double bonus;
	@Column(name = "DEDUCTIONS", columnDefinition = "VARCHAR(100)")
	private double deductions;
	@Column(name = "NETPAY", columnDefinition = "VARCHAR(100)")
	private double netPay;

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public double getDeductions() {
		return deductions;
	}

	public void setDeductions(double deductions) {
		this.deductions = deductions;
	}

	public double getNetPay() {
		return netPay;
	}

	public void setNetPay(double netPay) {
		this.netPay = netPay;
	}

}
