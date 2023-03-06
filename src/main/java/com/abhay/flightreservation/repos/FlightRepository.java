package com.abhay.flightreservation.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abhay.flightreservation.entities.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	// @Query(value="select f from Flight f where f.departureCity= :departureCity
	// and f.arrivalCity= :arrivalCity and f.dateOfDeparture= :dateOfDeparture")
	@Query("select f from Flight f where f.departureCity = :departureCity and f.arrivalCity =:arrivalCity and f.dateOfDeparture =:dateOfDeparture")
//	@Query("from flight where departureCity= :departureCity and arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture")
	List<Flight> findAll(@Param("departureCity") String from, @Param("arrivalCity") String to,
			@Param("dateOfDeparture") Date departureDate);

}
