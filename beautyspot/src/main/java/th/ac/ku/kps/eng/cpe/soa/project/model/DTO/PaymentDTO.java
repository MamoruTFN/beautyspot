package th.ac.ku.kps.eng.cpe.soa.project.model.DTO;

import java.util.Date;

public class PaymentDTO {
	
	private String storeName;
	private String phoneNumber;
	private String promotionName;
	private String firstName;
	private String lastName;
	private String tel;
	private String storepriceName;
	private Date reservationDate;
	private double price;
	
	public PaymentDTO() {
		super();
	}

	public PaymentDTO(String storeName, String phoneNumber, String promotionName, String firstName, String lastName,
			String tel, String storepriceName, Date reservationDate, double price) {
		super();
		this.storeName = storeName;
		this.phoneNumber = phoneNumber;
		this.promotionName = promotionName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.storepriceName = storepriceName;
		this.reservationDate = reservationDate;
		this.price = price;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
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

	public String getStorepriceName() {
		return storepriceName;
	}

	public void setStorepriceName(String storepriceName) {
		this.storepriceName = storepriceName;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

}
