package th.ac.ku.kps.eng.cpe.soa.project.model;
// Generated Apr 6, 2023, 12:03:22 AM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import th.ac.ku.kps.eng.cpe.soa.project.model.DTO.ReservationDTO;

/**
 * Reservation generated by hbm2java
 */
public class Reservation implements java.io.Serializable {

	private Integer reservationId;
	@JsonIgnore
	private Customer customer;
	@JsonIgnore
	private Promotion promotion;
	@JsonIgnore
	private Store store;
	private Date currentDate;
	private Date reservationDate;
	private String description;
	private Integer otherGroupId;
	@JsonIgnore
	private List<Payment> payments = new ArrayList<Payment>();

	public Reservation() {
	}

	public Reservation(Customer customer, Promotion promotion, Store store, Date currentDate, Date reservationDate,
			String description) {
		this.customer = customer;
		this.promotion = promotion;
		this.store = store;
		this.currentDate = currentDate;
		this.reservationDate = reservationDate;
		this.description = description;
	}

	public Reservation(Integer reservationId, Customer customer, Promotion promotion, Store store, Date currentDate,
			Date reservationDate, String description, Integer otherGroupId, List<Payment> payments) {
		super();
		this.reservationId = reservationId;
		this.customer = customer;
		this.promotion = promotion;
		this.store = store;
		this.currentDate = currentDate;
		this.reservationDate = reservationDate;
		this.description = description;
		this.otherGroupId = otherGroupId;
		this.payments = payments;
	}
	
	public void clone(Reservation other) {
		this.currentDate = other.currentDate;
		this.reservationDate = other.reservationDate;
		this.description = other.description;

	}
	
	public void cloneDto(ReservationDTO dto) {
		this.currentDate = dto.getCurrentDate();
		this.reservationDate = dto.getReservationDate();
		this.description = dto.getDescription();
	}

	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOtherGroupId() {
		return otherGroupId;
	}

	public void setOtherGroupId(Integer otherGroupId) {
		this.otherGroupId = otherGroupId;
	}

	public List<Payment> getPayments() {
		return payments;
	}

	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}

	

}
