package com.panonit.StinjanApp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public Apartment getById(@PathVariable(value = "apartmentId") Integer apartmentId){
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
	
	@GetMapping(value = "/showApartmentImage/{apartmentId}")
	public void showApartmentImage(@PathVariable Integer apartmentId, HttpServletResponse response,
			HttpServletRequest request) {

		try {
			Apartment apartment = apartmentService.getById(apartmentId);
			if(apartment.getImage() != null) {
				response.getOutputStream().write(apartment.getImage());
				response.getOutputStream().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value = "/uploadApartmentImage/{apartmentId}")
	public ResponseEntity<String> uploadApartmentImage(@RequestPart(value = "image") MultipartFile file,
			@PathVariable(value = "apartmentId") Integer apartmentId, HttpServletResponse response,
			HttpServletRequest request){
		if (!file.isEmpty())
			try {
				byte[] bytes = file.getBytes();
				
				Apartment apartment = apartmentService.getById(apartmentId);
				apartment.setImage(bytes);
				apartmentService.saveApartment(apartment);

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Upload failed", HttpStatus.BAD_REQUEST);
			}
		return new ResponseEntity<String>("Upload success", HttpStatus.OK);
	}
}
