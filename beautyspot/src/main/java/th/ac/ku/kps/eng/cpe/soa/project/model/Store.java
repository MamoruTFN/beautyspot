package th.ac.ku.kps.eng.cpe.soa.project.model;
// Generated Apr 6, 2023, 1:10:53 PM by Hibernate Tools 5.6.3.Final

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
	private String number;
	private String road;
	private String name;
	private Date openTime;
	private Date closeTime;
	private String phoneNumber;
	private String type;
	@JsonIgnore
	private List<Storeprice> storeprices = new ArrayList<Storeprice>();
	@JsonIgnore
	private List<Employee> employees = new ArrayList<Employee>();

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

	public Store(Integer storeId, Subdistrict subdistrict, String number, String road, String name, Date openTime,
			Date closeTime, String phoneNumber, String type, List<Storeprice> storeprices, List<Employee> employees) {
		super();
		this.storeId = storeId;
		this.subdistrict = subdistrict;
		this.number = number;
		this.road = road;
		this.name = name;
		this.openTime = openTime;
		this.closeTime = closeTime;
		this.phoneNumber = phoneNumber;
		this.type = type;
		this.storeprices = storeprices;
		this.employees = employees;
	}
	
	public void clone (Store other) {
		this.number = other.number;
		this.road = other.road;
		this.name = other.name;
		this.openTime = other.openTime;
		this.closeTime = other.closeTime;
		this.phoneNumber = other.phoneNumber;
		this.type = other.type;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRoad() {
		return road;
	}

	public void setRoad(String road) {
		this.road = road;
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

	public List<Storeprice> getStoreprices() {
		return storeprices;
	}

	public void setStoreprices(List<Storeprice> storeprices) {
		this.storeprices = storeprices;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	

}
