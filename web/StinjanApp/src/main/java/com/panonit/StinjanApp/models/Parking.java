package com.panonit.StinjanApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="parking")
@Getter
@Setter
public class Parking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="parkingId")
	int parkingId;
	
	@Column(name="available")
	private boolean available;

	public Parking() {
	}

	public Parking(int parkingId, boolean available) {
		super();
		this.parkingId = parkingId;
		this.available = available;
	}
}
