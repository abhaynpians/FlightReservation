package com.abhay.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhay.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
