package com.panonit.StinjanApp.controllers;

import java.util.List;
import java.util.Optional;

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

import com.panonit.StinjanApp.models.Trip;
import com.panonit.StinjanApp.services.TripService;

@RestController
@RequestMapping(value="trip")
public class TripController {
	
	@Autowired
	TripService tripService;
	
	@GetMapping("/list")
	public List<Trip> allTrips(){
		return tripService.allTrips();
	}
	
	@GetMapping("/getById/{tripId}")
	public Optional<Trip> getTripById(@PathVariable(value = "tripId") Integer tripId) {
		return tripService.getTripById(tripId);
	}
	
	@PostMapping("/save")
	public Trip saveTrip(@RequestBody Trip trip) {
		Trip tr = tripService.saveTrip(trip);
		return tripService.saveTrip(tr);
	}
	
	@PutMapping("/update/{tripId}")
	public Trip updateTrip(@RequestBody Trip trip, @PathVariable(value = "tripId") Integer tripId) {
		Trip tr = tripService.saveTrip(trip);
		return tripService.updateTrip(tr, tripId);
	}
	
	@DeleteMapping("/delete/{tripId}")
	public ResponseEntity<String> deleteTrip(@PathVariable(value="tripId") Integer tripId){
		try {
			tripService.deleteTrip(tripId);
		}catch(Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
