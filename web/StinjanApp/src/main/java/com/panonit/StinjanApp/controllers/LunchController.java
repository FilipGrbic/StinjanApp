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

import com.panonit.StinjanApp.models.Lunch;
import com.panonit.StinjanApp.services.LunchService;

@RestController
@RequestMapping("lunch")
@CrossOrigin(origins = "http://localhost:4200")
public class LunchController {
	
	@Autowired
	LunchService lunchService;
	
	@GetMapping("/list")
	public List<Lunch> allLunches(){
		return lunchService.allLunches();
	}
	
	@GetMapping("/getById/{lunchId}")
	public Lunch getById(@PathVariable(value = "lunchId") Integer lunchId){
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
	
	@GetMapping(value = "/showLunchImage/{lunchId}")
	public void showLunchImage(@PathVariable Integer lunchId, HttpServletResponse response,
			HttpServletRequest request) {

		try {
			Lunch lunch = lunchService.getById(lunchId);
			if(lunch.getImage() != null) {
				response.getOutputStream().write(lunch.getImage());
				response.getOutputStream().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value = "/uploadLunchImage/{lunchId}")
	public ResponseEntity<String> uploadLunchImage(@RequestPart(value = "image") MultipartFile file,
			@PathVariable(value = "lunchId") Integer lunchId, HttpServletResponse response,
			HttpServletRequest request){
		if (!file.isEmpty())
			try {
				byte[] bytes = file.getBytes();
				
				Lunch lunch = lunchService.getById(lunchId);
				lunch.setImage(bytes);
				lunchService.saveLunch(lunch);

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Upload failed", HttpStatus.BAD_REQUEST);
			}
		return new ResponseEntity<String>("Upload success", HttpStatus.OK);
	}
}
