package com.panonit.StinjanApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.models.Lunch;
import com.panonit.StinjanApp.repositories.LunchRepository;

@Service("lunchService")
public class LunchService {
	
	@Autowired
	LunchRepository lunchRepository;
	
	public List<Lunch> allLunches(){
		return lunchRepository.findAll();
	}
	
	public Optional<Lunch> getById(Integer lunchId) {
		return lunchRepository.findById(lunchId);
	}
	
	public Lunch saveLunch(Lunch lunch) {
		return lunchRepository.save(lunch);
	}
	
	public Lunch updateLunch(Lunch newLunch, Integer lunchId) {
		newLunch.setLunchId(lunchId);
		return lunchRepository.save(newLunch);
	}
	
	public void deleteLunch(Integer lunchId) {
		lunchRepository.deleteById(lunchId);
	}
}
