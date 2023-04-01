package model;
// Generated Apr 1, 2023, 2:32:11 PM by Hibernate Tools 5.6.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * User generated by hbm2java
 */
public class User implements java.io.Serializable {

	private Integer userId;
	private Role role;
	private String name;
	private String email;
	private String pwd;
	private String phonenumber;
	private Set stores = new HashSet(0);
	private Set payments = new HashSet(0);
	private Set reservations = new HashSet(0);

	public User() {
	}

	public User(Role role, String name, String email, String pwd, String phonenumber) {
		this.role = role;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phonenumber = phonenumber;
	}

	public User(Role role, String name, String email, String pwd, String phonenumber, Set stores, Set payments,
			Set reservations) {
		this.role = role;
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phonenumber = phonenumber;
		this.stores = stores;
		this.payments = payments;
		this.reservations = reservations;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Set getStores() {
		return this.stores;
	}

	public void setStores(Set stores) {
		this.stores = stores;
	}

	public Set getPayments() {
		return this.payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}

	public Set getReservations() {
		return this.reservations;
	}

	public void setReservations(Set reservations) {
		this.reservations = reservations;
	}

}
