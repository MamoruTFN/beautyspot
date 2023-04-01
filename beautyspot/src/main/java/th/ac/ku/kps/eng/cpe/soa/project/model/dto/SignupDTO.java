package th.ac.ku.kps.eng.cpe.soa.project.model.dto;

import javax.validation.constraints.Email;

import th.ac.ku.kps.eng.cpe.soa.project.service.matcher.PasswordMatches;

@PasswordMatches
public class SignupDTO {
	private String name;
	@Email
	private String email;
	private String pwd;
	private String phonenumber;
	String matchingPassword;
	public SignupDTO() {
		
	}
	public SignupDTO(String name, String email, String pwd, String phonenumber, String matchingPassword) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phonenumber = phonenumber;
		this.matchingPassword = matchingPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getMatchingPassword() {
		return matchingPassword;
	}
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

}
