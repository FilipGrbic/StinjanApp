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

import com.panonit.StinjanApp.models.Apartment;
import com.panonit.StinjanApp.services.ApartmentService;

@RestController
@RequestMapping("apartment")
public class ApartmentController {
	
	@Autowired
	ApartmentService apartmentService;
	
	@GetMapping("/list")
	public List<Apartment> allApartments(){
		return apartmentService.allApartments();
	}
	
	@GetMapping("/getById/{apartmentId}")
	public Optional<Apartment> getById(@PathVariable(value = "apartmentId") Integer apartmentId){
		return apartmentService.getById(apartmentId);
	}
	
	@PostMapping("/save")
	public Apartment saveApartment(@RequestBody Apartment apartment) {
		Apartment ap = apartmentService.saveApartment(apartment);
		return ap;
	}
	
	@PutMapping("/update/{apartmentId}")
	public Apartment updateApartment(@RequestBody Apartment apartment, @PathVariable(value = "apartmentId") Integer apartmentId) {
		Apartment ap = apartmentService.saveApartment(apartment);
		return apartmentService.updateApartment(ap, apartmentId);
	}
	
	@DeleteMapping("/delete/{apartmentId}")
	public ResponseEntity<String> deleteApartment(@PathVariable(value = "apartmentId") Integer apartmentId){
		try {
			apartmentService.deleteApartment(apartmentId);
		} catch(Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
