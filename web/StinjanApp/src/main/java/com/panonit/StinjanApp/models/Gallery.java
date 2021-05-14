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
@Table(name="gallery")
@Getter
@Setter
public class Gallery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="imgId")
	int imgId;
	
	@Column(name="img")
	private byte[] img;
	
	@Column(name="description")
	private String description;
	
	public Gallery() {
	}

	public Gallery(int imgId, byte[] img, String description) {
		super();
		this.imgId = imgId;
		this.img = img;
		this.description = description;
	}
}
