package com.panonit.StinjanApp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.models.Trip;
import com.panonit.StinjanApp.repositories.TripRepository;

@Service("tripService")
public class TripService {
	
	@Autowired
	TripRepository tripRepository;
	
	public List<Trip> allTrips(){
		return tripRepository.findAll();
	}
	
	public Trip getTripById(Integer tripId) {
		return tripRepository.findById(tripId).get();
	}
	
	public Trip saveTrip(Trip trip) {
		return tripRepository.save(trip);
	}
	
	public Trip updateTrip(Trip newTrip, Integer tripId) {
		newTrip.setTripId(tripId);
		return tripRepository.save(newTrip);
	}
	
	public void deleteTrip(Integer tripId) {
		tripRepository.deleteById(tripId);
	}
}
