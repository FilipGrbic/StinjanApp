package com.panonit.StinjanApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panonit.StinjanApp.models.Parking;

@Repository("parkingRepository")
public interface ParkingRepository extends JpaRepository<Parking, Integer>{

}
