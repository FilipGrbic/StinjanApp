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

import com.panonit.StinjanApp.models.Lunch;
import com.panonit.StinjanApp.services.LunchService;

@RestController
@RequestMapping("lunch")
public class LunchController {
	
	@Autowired
	LunchService lunchService;
	
	@GetMapping("/list")
	public List<Lunch> allLunches(){
		return lunchService.allLunches();
	}
	
	@GetMapping("/getById/{lunchId}")
	public Optional<Lunch> getById(@PathVariable(value = "lunchId") Integer lunchId){
		return lunchService.getById(lunchId);
	}
	
	@PostMapping("/save")
	public Lunch saveLunch(@RequestBody Lunch lunch) {
		Lunch lun = lunchService.saveLunch(lunch);
		return lun;
	}
	
	@PutMapping("/update/{lunchId}")
	public Lunch updateLunch(@RequestBody Lunch lunch, @PathVariable(value = "lunchId") Integer lunchId) {
		Lunch lun = lunchService.saveLunch(lunch);
		return lunchService.updateLunch(lun, lunchId);
	}
	
	@DeleteMapping("/delete/{lunchId}")
	public ResponseEntity<String> deleteLunch(@PathVariable(value = "lunchId") Integer lunchId){
		try {
			lunchService.deleteLunch(lunchId);
		} catch(Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
