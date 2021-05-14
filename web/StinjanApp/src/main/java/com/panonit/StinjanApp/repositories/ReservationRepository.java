package com.panonit.StinjanApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panonit.StinjanApp.models.Reservation;

@Repository("reservationRepository")
public interface ReservationRepository extends JpaRepository<Reservation,Integer>{

}
