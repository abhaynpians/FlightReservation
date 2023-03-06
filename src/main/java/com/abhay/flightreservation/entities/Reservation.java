package com.abhay.flightreservation.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Reservation extends AbstractEntity {

	private boolean checkedIn;
	@Column(name = "number_of_bags")
	private int numberOfBages;

	@OneToOne
	private Passenger passenger;
	@OneToOne
	private Flight flight;

	public boolean isCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public int getNumberOfBages() {
		return numberOfBages;
	}

	public void setNumberOfBages(int numberOfBages) {
		this.numberOfBages = numberOfBages;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

}
