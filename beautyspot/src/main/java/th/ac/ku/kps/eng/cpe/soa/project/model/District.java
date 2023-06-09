package th.ac.ku.kps.eng.cpe.soa.project.model;
// Generated Apr 5, 2023, 5:31:43 PM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * District generated by hbm2java
 */
public class District implements java.io.Serializable {

	private Integer districtId;	
	@JsonIgnore
	private Province province;
	private String name;
	@JsonIgnore
	private List<Subdistrict> subdistricts = new ArrayList<>();

	public District() {
	}

	public District(Province province, String name) {
		this.province = province;
		this.name = name;
	}

	public District(Integer districtId, Province province, String name, List<Subdistrict> subdistricts) {
		super();
		this.districtId = districtId;
		this.province = province;
		this.name = name;
		this.subdistricts = subdistricts;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subdistrict> getSubdistricts() {
		return subdistricts;
	}

	public void setSubdistricts(List<Subdistrict> subdistricts) {
		this.subdistricts = subdistricts;
	}

}
