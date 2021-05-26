package com.panonit.StinjanApp.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.panonit.StinjanApp.models.Reservation;
import com.panonit.StinjanApp.services.ReservationService;

@RestController
@RequestMapping("reservation")
public class ReservationController {
	
	@Autowired
	ReservationService reservationService;
	
	@GetMapping("/list")
	public List<Reservation> allReservations(){
		return reservationService.allReservations();
	}
	
	@GetMapping("/getById/{reservationId}")
	public Reservation getById(@PathVariable(value = "reservationId") Integer reservationId){
		return reservationService.getById(reservationId);
	}
	
	@PostMapping("/save")
	public Reservation saveReservation(@RequestBody Reservation reservation) {
		Reservation reserv = reservationService.saveReservation(reservation);
		return reserv;
	}
	
	@PutMapping("/update/{reservationId}")
	public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable(value = "reservationId") Integer reservationId) {
		Reservation reserv = reservationService.saveReservation(reservation);
		return reservationService.updateReservation(reserv, reservationId);
	}
	
	@DeleteMapping("/delete/{reservationId}")
	public ResponseEntity<String> deleteReservation(@PathVariable(value = "reservationId") Integer reservationId){
		try {
			reservationService.deleteReservation(reservationId);
		} catch(Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
