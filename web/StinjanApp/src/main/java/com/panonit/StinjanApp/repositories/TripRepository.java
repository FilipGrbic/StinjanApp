package com.panonit.StinjanApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panonit.StinjanApp.models.Trip;

@Repository("tripRepository")
public interface TripRepository extends JpaRepository<Trip, Integer> {
	
}
