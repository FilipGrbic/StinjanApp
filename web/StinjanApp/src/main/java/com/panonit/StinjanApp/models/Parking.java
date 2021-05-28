package com.panonit.StinjanApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="parking")
@Getter
@Setter
public class Parking {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="parkingId")
	int parkingId;
	
	@Column(name="serial_num")
	private int serial_num;
	
	@Column(name="available")
	private boolean available;

	public Parking() {
	}

	public Parking(int parkingId, int serial_num, boolean available) {
		super();
		this.parkingId = parkingId;
		this.serial_num = serial_num;
		this.available = available;
	}
}
