package model;
// Generated Apr 5, 2023, 6:40:37 PM by Hibernate Tools 5.6.3.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Store generated by hbm2java
 */
public class Store implements java.io.Serializable {

	private Integer storeId;
	private Subdistrict subdistrict;
	private String number;
	private String road;
	private String name;
	private Date openTime;
	private Date closeTime;
	private String phoneNumber;
	private String type;
	private Set reservations = new HashSet(0);
	private Set employees = new HashSet(0);

	public Store() {
	}

	public Store(Subdistrict subdistrict, String number, String road, String name, Date openTime, Date closeTime,
			String phoneNumber, String type) {
		this.subdistrict = subdistrict;
		this.number = number;
		this.road = road;
		this.name = name;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.phoneNumber = phoneNumber;
		this.type = type;
	}

	public Store(Subdistrict subdistrict, String number, String road, String name, Date openTime, Date closeTime,
			String phoneNumber, String type, Set reservations, Set employees) {
		this.subdistrict = subdistrict;
		this.number = number;
		this.road = road;
		this.name = name;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.reservations = reservations;
		this.employees = employees;
	}

	public Integer getStoreId() {
		return this.storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public Subdistrict getSubdistrict() {
		return this.subdistrict;
	}

	public void setSubdistrict(Subdistrict subdistrict) {
		this.subdistrict = subdistrict;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRoad() {
		return this.road;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getOpenTime() {
		return this.openTime;
	}

	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}

	public Date getCloseTime() {
		return this.closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set getReservations() {
		return this.reservations;
	}

	public void setReservations(Set reservations) {
		this.reservations = reservations;
	}

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

}
