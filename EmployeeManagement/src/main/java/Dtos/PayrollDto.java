package Dtos;

public class PayrollDto {
	private double basicSalary;
	private double bonus;
	private double deductions;
	private double netPay;

	public PayrollDto() {
		super();
//		this.basicSalary = basicSalary;
//		this.bonus = bonus;
//		this.deductions = deductions;
//		this.netPay = netPay;
	}

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
