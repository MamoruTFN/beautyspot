package th.ac.ku.kps.eng.cpe.soa.project.model.DTO;

import java.util.Date;

public class StoreDTO {
	private Integer storeId;
	private String number;
	private String road;
	private String name;
	private String subdistrict;
	private String district;
	private String province;
	private Date openTime;
	private Date closeTime;
	private String phoneNumber;
	private String type;
	
	public StoreDTO() {
		super();
	}

	public StoreDTO(Integer storeId, String number, String road, String name, String subdistrict, String district,
			String province, Date openTime, Date closeTime, String phoneNumber, String type) {
		super();
		this.storeId = storeId;
		this.number = number;
		this.road = road;
		this.name = name;
		this.subdistrict = subdistrict;
		this.district = district;
		this.province = province;
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

	public String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(String subdistrict) {
		this.subdistrict = subdistrict;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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
	
	

}
