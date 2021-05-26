package com.panonit.StinjanApp.controllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.panonit.StinjanApp.models.Trip;
import com.panonit.StinjanApp.services.TripService;

@RestController
@RequestMapping(value="trip")
@CrossOrigin(origins = "http://localhost:4200")
public class TripController {
	
	@Autowired
	TripService tripService;
	
	@GetMapping("/list")
	public List<Trip> allTrips(){
		return tripService.allTrips();
	}
	
	@GetMapping("/getById/{tripId}")
	public Trip getTripById(@PathVariable(value = "tripId") Integer tripId) {
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
	
	@GetMapping(value = "/showTripImage/{tripId}")
	public void showTripImage(@PathVariable Integer tripId, HttpServletResponse response,
			HttpServletRequest request) {

		try {
			Trip trip = tripService.getTripById(tripId);
			if(trip.getImage() != null) {
				response.getOutputStream().write(trip.getImage());
				response.getOutputStream().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value = "/uploadTripImage/{tripId}")
	public ResponseEntity<String> UploadTripImage(@RequestPart(value = "image") MultipartFile file,
			@PathVariable(value = "tripId") Integer tripId, HttpServletResponse response,
			HttpServletRequest request){
		if (!file.isEmpty())
			try {
				byte[] bytes = file.getBytes();
				
				Trip trip = tripService.getTripById(tripId);
				trip.setImage(bytes);
				tripService.saveTrip(trip);

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Upload failed", HttpStatus.BAD_REQUEST);
			}
		return new ResponseEntity<String>("Upload success", HttpStatus.OK);
	}
}
