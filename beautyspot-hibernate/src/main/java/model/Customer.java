package model;
// Generated Apr 5, 2023, 6:40:37 PM by Hibernate Tools 5.6.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Customer generated by hbm2java
 */
public class Customer implements java.io.Serializable {

	private Integer customerId;
	private String firstName;
	private String lastName;
	private String tel;
	private Set payments = new HashSet(0);
	private Set reservations = new HashSet(0);

	public Customer() {
	}

	public Customer(String firstName, String lastName, String tel) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
	}

	public Customer(String firstName, String lastName, String tel, Set payments, Set reservations) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.tel = tel;
		this.payments = payments;
		this.reservations = reservations;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
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
