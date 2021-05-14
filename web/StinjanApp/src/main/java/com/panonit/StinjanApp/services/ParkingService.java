package com.panonit.StinjanApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.models.Parking;
import com.panonit.StinjanApp.repositories.ParkingRepository;

@Service("parkingService")
public class ParkingService {
	
	@Autowired
	ParkingRepository parkingRepository;
	
	public List<Parking> allParkings(){
		return parkingRepository.findAll();
	}
	
	public Optional<Parking> getParkingById(Integer parkingId) {
		return parkingRepository.findById(parkingId);
	}
	
	public Parking saveParking(Parking parking) {
		return parkingRepository.save(parking);
	}
	
	public Parking updateParking(Parking newParking, Integer parkingId) {
		newParking.setParkingId(parkingId);
		return parkingRepository.save(newParking);
	}
	
	public void deleteParking(Integer parkingId) {
		parkingRepository.deleteById(parkingId);
	}
}
