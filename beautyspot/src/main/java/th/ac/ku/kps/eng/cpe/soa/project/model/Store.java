package th.ac.ku.kps.eng.cpe.soa.project.model;
// Generated Apr 1, 2023, 2:32:11 PM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Store generated by hbm2java
 */
public class Store implements java.io.Serializable {

	private Integer storeId;
	@JsonIgnore
	private Subdistrict subdistrict;
	@JsonIgnore
	private User user;
	private String name;
	private Date openTime;
	private Date closeTime;
	private String phoneNumber;
	private String type;
	@JsonIgnore
	private List<Reservation> reservations = new ArrayList<Reservation>();

	public Store() {
	}

	public Store(Subdistrict subdistrict, String name, Date openTime, Date closeTime, String phoneNumber, String type) {
		this.subdistrict = subdistrict;
		this.name = name;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.phoneNumber = phoneNumber;
		this.type = type;
	}

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Subdistrict getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(Subdistrict subdistrict) {
		this.subdistrict = subdistrict;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpenTime() {
		return openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

}
