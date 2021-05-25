package com.panonit.StinjanApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panonit.StinjanApp.models.Apartment;

@Repository("apartmentRepository")
public interface ApartmentRepository extends JpaRepository<Apartment, Integer>{

}
