package com.abhay.flightreservation.dto;

import jakarta.persistence.Column;

public class ReservationUpdateRequest {

	private long id;

	@Column(name = "number_of_bags")
	private int NumberOfBages;
	@Column(name = "checked_in")
	boolean checkedIn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNumberOfBages() {
		return NumberOfBages;
	}

	public void setNumberOfBages(int numberOfBags) {
		this.NumberOfBages = numberOfBags;
	}

	public boolean getCheckedIn() {
		return checkedIn;
	}

	public void setCheckIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

}
