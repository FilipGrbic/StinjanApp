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
@Table(name="gallery")
@Getter
@Setter
public class Gallery {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="imgId")
	int imgId;
	
	@Column(name="img")
	private byte[] img;
	
	@Size(max=200)
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
