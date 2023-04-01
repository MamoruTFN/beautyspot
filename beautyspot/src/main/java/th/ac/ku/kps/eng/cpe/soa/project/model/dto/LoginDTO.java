package th.ac.ku.kps.eng.cpe.soa.project.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class LoginDTO {
	@Email
	private String email;
	@NotBlank
	private String password;
	
	public LoginDTO() {
	}

	public LoginDTO(@Email String email, @NotBlank String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
