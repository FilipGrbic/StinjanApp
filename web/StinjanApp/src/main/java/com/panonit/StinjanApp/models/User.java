package com.panonit.StinjanApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	int userId;
	
	@OneToOne
	@JoinColumn(name = "roleId")
	Role role;
	
	@Column(name="name")
	private String name;
	
	@Column(name="surname")
	private String surname;
	
	@Column(name="country")
	private String country;
	
	@Column(name="city")
	private String city;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="description")
	private String description;
	
	public User() {
	}

	public User(int userId, Role role, String name, String surname, String country, String city, String email,
			String phone, String username, String password, String description) {
		super();
		this.userId = userId;
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.country = country;
		this.city = city;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.description = description;
	}
}
