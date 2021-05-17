package com.panonit.StinjanApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="user")
@Getter
@Setter
public class User {
	
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userId")
	int userId;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "roleId")
	Role role;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-ZšđčćžŠĐČĆŽ ]+$")
	@Size(min=2, max=60)
	@Column(name="name")
	private String name;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-ZšđčćžŠĐČĆŽ ]+$")
	@Size(min=2, max=60)
	@Column(name="surname")
	private String surname;
	
	@Pattern(regexp = "^[a-zA-ZšđčćžŠĐČĆŽ ]+$")
	@Column(name="country")
	private String country;
	
	@Column(name="city")
	private String city;
	
	@Size(min=5)
	@Column(name="address")
	private String address;
	
	@NotNull
	@Email
	@Column(name="email")
	private String email;
	
	@NotNull
	@Pattern(regexp = "^[0-9]*$")
	@Column(name="phone")
	private String phone;
	
	@NotNull
	@Size(min=3, max=30)
	@Column(name="username")
	private String username;
	
	@NotNull
	@Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,}$")
	@Column(name="password")
	private String password;
	
	@Size(max=200)
	@Column(name="description")
	private String description;
	
	public User() {
	}

	public User(int userId, Role role, String name, String surname, String country, String city, String address, String email,
			String phone, String username, String password, String description) {
		super();
		this.userId = userId;
		this.role = role;
		this.name = name;
		this.surname = surname;
		this.country = country;
		this.city = city;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.description = description;
	}
}
