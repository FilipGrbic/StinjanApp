package com.panonit.StinjanApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panonit.StinjanApp.models.Lunch;

@Repository("lunchRepository")
public interface LunchRepository extends JpaRepository<Lunch,Integer> {

}
