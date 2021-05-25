package com.panonit.StinjanApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.models.Apartment;
import com.panonit.StinjanApp.repositories.ApartmentRepository;

@Service("apartmentService")
public class ApartmentService {
	
	@Autowired
	ApartmentRepository apartmentRepository;
	
	public List<Apartment> allApartments(){
		return apartmentRepository.findAll();
	}
	
	public Optional<Apartment> getById(Integer apartmentId) {
		return apartmentRepository.findById(apartmentId);
	}
	
	public Apartment saveApartment(Apartment apartment) {
		return apartmentRepository.save(apartment);
	}
	
	public Apartment updateApartment(Apartment newApartment, Integer apartmentId) {
		newApartment.setApartmentId(apartmentId);
		return apartmentRepository.save(newApartment);
	}
	
	public void deleteApartment(Integer apartmentId) {
		apartmentRepository.deleteById(apartmentId);
	}
}
