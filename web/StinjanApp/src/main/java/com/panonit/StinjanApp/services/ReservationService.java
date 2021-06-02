package com.panonit.StinjanApp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.models.Reservation;
import com.panonit.StinjanApp.repositories.ReservationRepository;

@Service("reservationService")
public class ReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	public List<Reservation> allReservations(){
		return reservationRepository.findAll();
	}
	
	public Reservation getById(Integer reservationId){
		return reservationRepository.findById(reservationId).get();
	}
	
	public Reservation saveReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}
	
	public Reservation updateReservation(Reservation reservation, Integer reservationId) {
		reservation.setReservationId(reservationId);
		return reservationRepository.save(reservation);
	}
	
	public void deleteReservation(Integer reservationId) {
		reservationRepository.deleteById(reservationId);
	}
}
