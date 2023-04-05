package model;
// Generated Apr 5, 2023, 1:27:16 PM by Hibernate Tools 5.6.3.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Promotion generated by hbm2java
 */
public class Promotion implements java.io.Serializable {

	private Integer promotionId;
	private String name;
	private double percentDiscount;
	private Set reservations = new HashSet(0);
	private Set payments = new HashSet(0);

	public Promotion() {
	}

	public Promotion(String name, double percentDiscount) {
		this.name = name;
		this.percentDiscount = percentDiscount;
	}

	public Promotion(String name, double percentDiscount, Set reservations, Set payments) {
		this.name = name;
		this.percentDiscount = percentDiscount;
		this.reservations = reservations;
		this.payments = payments;
	}

	public Integer getPromotionId() {
		return this.promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentDiscount() {
		return this.percentDiscount;
	}

	public void setPercentDiscount(double percentDiscount) {
		this.percentDiscount = percentDiscount;
	}

	public Set getReservations() {
		return this.reservations;
	}

	public void setReservations(Set reservations) {
		this.reservations = reservations;
	}

	public Set getPayments() {
		return this.payments;
	}

	public void setPayments(Set payments) {
		this.payments = payments;
	}

}
