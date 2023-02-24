package com.abhay.flightreservation.services;

import com.abhay.flightreservation.dto.ReservationRequest;
import com.abhay.flightreservation.entities.Reservation;

public interface ReservationService {
	public Reservation bookFlight(ReservationRequest request);

}
