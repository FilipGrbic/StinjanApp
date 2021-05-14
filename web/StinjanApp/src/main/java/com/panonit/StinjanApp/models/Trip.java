package com.panonit.StinjanApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="trip")
@Getter
@Setter
public class Trip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="tripId")
	int tripId;
	
	@Column(name = "title")
	private String title;
	
	@Column(name="price")
	private int price;
	
	@Lob
	@Column(name="image")
	private byte[] image;
	
	@Column(name= "description")
	private String description;

	public Trip() {
	}

	public Trip(int tripId, String title, int price, byte[] image, String description) {
		super();
		this.tripId = tripId;
		this.title = title;
		this.price = price;
		this.image = image;
		this.description = description;
	}
}
