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
@Table(name="lunch")
@Getter
@Setter
public class Lunch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="lunchId")
	int lunchId;
	
	@Column(name="price")
	private int price;
	
	@Column(name="image")
	private byte[] image;
	
	@Column(name="description")
	private String description;
	
	public Lunch() {
	}

	public Lunch(int lunchId, int price, byte[] image, String description) {
		super();
		this.lunchId = lunchId;
		this.price = price;
		this.image = image;
		this.description = description;
	}
}
