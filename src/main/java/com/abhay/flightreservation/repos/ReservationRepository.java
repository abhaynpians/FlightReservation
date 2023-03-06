package com.abhay.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhay.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
