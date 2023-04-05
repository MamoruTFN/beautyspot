package th.ac.ku.kps.eng.cpe.soa.project.model.DTO;

import java.util.Date;

public class ReservationDTO {
	
	private String firstName;
	private String lastName;
	private String tel;
	private Date currentDate;
	private Date reservationDate;
	private String description;
	private Integer otherGroupId;
	public ReservationDTO() {
		super();
	}
	public ReservationDTO(String firstName, String lastName, String tel, Date currentDate, Date reservationDate,
			String description, Integer otherGroupId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.currentDate = currentDate;
		this.reservationDate = reservationDate;
		this.description = description;
		this.otherGroupId = otherGroupId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getOtherGroupId() {
		return otherGroupId;
	}
	public void setOtherGroupId(Integer otherGroupId) {
		this.otherGroupId = otherGroupId;
	}
	
	

}
