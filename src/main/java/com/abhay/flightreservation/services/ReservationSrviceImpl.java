package com.abhay.flightreservation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.abhay.flightreservation.dto.ReservationRequest;
import com.abhay.flightreservation.entities.Flight;
import com.abhay.flightreservation.entities.Passenger;
import com.abhay.flightreservation.entities.Reservation;
import com.abhay.flightreservation.repos.FlightRepository;
import com.abhay.flightreservation.repos.PassengerRepository;
import com.abhay.flightreservation.repos.ReservationRepository;
import com.abhay.flightreservation.util.EmailUtil;
import com.abhay.flightreservation.util.PDFGenerator;

@Service
public class ReservationSrviceImpl implements ReservationService {

	@Autowired
	FlightRepository flightRepository;

	@Autowired
	PassengerRepository passengerRepository;

	@Autowired
	PDFGenerator pdfGenerator;

	@Autowired
	EmailUtil emailUtil;

	@Autowired
	ReservationRepository reservationRepository;

	@Override
	public Reservation bookFlight(ReservationRequest request) {

		// request.getCardNumber();

		Long flightId = request.getFlightId();

		System.out.println("This is Flight id: " + flightId);
		Flight flight = flightRepository.findById(flightId).orElse(null);
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastname(request.getPassengerLastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);

		Reservation savedReservation = reservationRepository.save(reservation);

		String filePath = "C:\\Users\\Trilok Joshi\\Documents\\pdf" + savedReservation.getId() + ".pdf";
		pdfGenerator.generateItinerary(savedReservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(), filePath);

		return savedReservation;

	}
}