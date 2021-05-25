package com.panonit.StinjanApp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="reservation")
@Getter
@Setter
public class Reservation {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "reservationId")
	int reservationId;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "dateFrom")
	private Date dateFrom;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "dateTo")
	private Date dateTo;
	
	@NotNull
	@Column(name="totalPrice")
	private int totalPrice;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "tripId")
	Trip trip;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "parkingId")
	Parking parking;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "apartmentId")
	Apartment apartment;
	
	public Reservation() {
	}

	public Reservation(int reservationId, Date dateFrom, Date dateTo, int totalPrice, Trip trip, Parking parking,
			Apartment apartment) {
		super();
		this.reservationId = reservationId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.totalPrice = totalPrice;
		this.trip = trip;
		this.parking = parking;
		this.apartment = apartment;
	}
}
