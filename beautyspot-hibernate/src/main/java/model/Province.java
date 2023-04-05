package model;
// Generated Apr 5, 2023, 6:40:37 PM by Hibernate Tools 5.6.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Province generated by hbm2java
 */
public class Province implements java.io.Serializable {

	private Integer provinceId;
	private String name;
	private Set districts = new HashSet(0);

	public Province() {
	}

	public Province(String name) {
		this.name = name;
	}

	public Province(String name, Set districts) {
		this.name = name;
		this.districts = districts;
	}

	public Integer getProvinceId() {
		return this.provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getDistricts() {
		return this.districts;
	}

	public void setDistricts(Set districts) {
		this.districts = districts;
	}

}
