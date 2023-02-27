package com.abhay.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhay.flightreservation.dto.ReservationUpdateRequest;
import com.abhay.flightreservation.entities.Reservation;
import com.abhay.flightreservation.repos.ReservationRepository;

@RestController
public class ReservationRestController {

	@Autowired
	ReservationRepository reservationRepo;
	
	@RequestMapping("/reservation/{id}")
	public Reservation findReservation(@PathVariable("id") long id) {
		return reservationRepo.findById(id).orElse(null);
	}
	@RequestMapping("/reservation")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		Reservation reservation=	reservationRepo.findById(request.getId()).orElse(null);
		reservation.setCheckedIn(request.getCheckedIn());
		reservation.setNumberOfBages(request.getNumberOfBages());
		return reservationRepo.save(reservation);
	}
	
	
}
