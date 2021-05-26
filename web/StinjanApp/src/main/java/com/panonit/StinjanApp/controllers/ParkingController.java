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

import com.panonit.StinjanApp.models.Parking;
import com.panonit.StinjanApp.services.ParkingService;

@RestController
@RequestMapping(value="parking")
public class ParkingController {
	
	@Autowired
	ParkingService parkingService;
	
	@GetMapping("/list")
	public List<Parking> allParkings(){
		return parkingService.allParkings();
	}
	
	@GetMapping("/getById/{parkingId}")
	public Parking getParkingById(@PathVariable(value = "parkingId") Integer parkingId) {
		return parkingService.getParkingById(parkingId);
	}
	
	@PostMapping("/save")
	public Parking saveParking(@RequestBody Parking parking) {
		Parking park = parkingService.saveParking(parking);
		return park;
	}
	
	@PutMapping("/update/{parkingId}")
	public Parking updateParking(@RequestBody Parking parking, @PathVariable(value = "parkingId") Integer parkingId) {
		Parking park = parkingService.saveParking(parking);
		return parkingService.updateParking(park, parkingId);
	}
	
	@DeleteMapping("/delete/{parkingId}")
	public ResponseEntity<String> deleteParking(@PathVariable(value = "parkingId") Integer parkingId){
		try {
			parkingService.deleteParking(parkingId);
		} catch(Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
