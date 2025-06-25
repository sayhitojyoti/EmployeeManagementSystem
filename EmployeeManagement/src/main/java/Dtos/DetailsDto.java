package Dtos;

public class DetailsDto {
	private String gender;
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
	private String email;
	public DetailsDto() {
		super();
//		this.gender = gender;
//		this.email = email;
	}
}
