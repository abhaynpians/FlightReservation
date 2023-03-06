package com.abhay.flightreservation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Passenger extends AbstractEntity {

	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastname;
	@Column(name = "middle_name")
	private String middleNmae;
	private String email;
	private String phone;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddleNmae() {
		return middleNmae;
	}

	public void setMiddleNmae(String middleNmae) {
		this.middleNmae = middleNmae;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
