package com.panonit.StinjanApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="apartment")
@Getter
@Setter
public class Apartment {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="apartmentId")
	int apartmentId;
	
	@NotNull
	@Column(name="num_of_rooms")
	private int num_of_rooms;
	
	@NotNull
	@Column(name="num_of_beds")
	private int num_of_beds;
	
	@Size(max=200)
	@Column(name="description")
	private String description;
	
	@Column(name="image")
	private byte[] image;
	
	@NotNull
	@Column(name="price_per_night")
	private int price_per_night;
	
	public Apartment() {
	}

	public Apartment(int apartmentId, int num_of_rooms, int num_of_beds, String description, byte[] image,
			int price_per_night) {
		super();
		this.apartmentId = apartmentId;
		this.num_of_rooms = num_of_rooms;
		this.num_of_beds = num_of_beds;
		this.description = description;
		this.image = image;
		this.price_per_night = price_per_night;
	}
}
