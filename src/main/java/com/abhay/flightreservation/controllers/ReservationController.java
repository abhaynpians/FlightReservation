package com.abhay.flightreservation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhay.flightreservation.dto.ReservationRequest;
import com.abhay.flightreservation.entities.Flight;
import com.abhay.flightreservation.entities.Reservation;
import com.abhay.flightreservation.repos.FlightRepository;
import com.abhay.flightreservation.services.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationService reservatinService;
	
	
	
	@RequestMapping("/showCompleteReservation")
	public String shoCompleteReservation(@RequestParam("flightId") long flightId , ModelMap modelMap) {
		
		Flight flight = flightRepository.findById(flightId).orElse(null);
		//flightRepository.findOne(flightId));
		modelMap.addAttribute("flight", flight);
		return "CompleteReservation";
	}
	
	@RequestMapping(value="/CompleteReservation", method=RequestMethod.POST )
	public String CompleteReservation(ReservationRequest request , ModelMap modelMap) {
		Reservation reservation = reservatinService.bookFlight(request);
		
		modelMap.addAttribute("msg","Reservation created successfully and the id is "+ reservation.getId());
		
		
		return "reservationConfirmation";
		
	}
	
	
	
	

}
