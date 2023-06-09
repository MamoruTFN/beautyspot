package model;
// Generated Apr 5, 2023, 6:40:37 PM by Hibernate Tools 5.6.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Role generated by hbm2java
 */
public class Role implements java.io.Serializable {

	private Integer roleId;
	private String name;
	private Set employees = new HashSet(0);

	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	public Role(String name, Set employees) {
		this.name = name;
		this.employees = employees;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set employees) {
		this.employees = employees;
	}

}
