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

import com.panonit.StinjanApp.models.Gallery;
import com.panonit.StinjanApp.services.GalleryService;

@RestController
@RequestMapping("image")
public class GalleryController {
	
	@Autowired
	GalleryService galleryService;
	
	@GetMapping("/list")
	public List<Gallery> allImages(){
		return galleryService.allImages();
	}
	
	@GetMapping("/getById/{imgId}")
	public Optional<Gallery> getById(@PathVariable(value = "imgId") Integer imgId){
		return galleryService.getById(imgId);
	}
	
	@PostMapping("/save")
	public Gallery saveImage(@RequestBody Gallery gallery) {
		Gallery img = galleryService.saveImage(gallery);
		return img;
	}
	
	@PutMapping("/update/{imgId}")
	public Gallery updateImage(@RequestBody Gallery gallery, @PathVariable(value = "imgId") Integer imgId) {
		Gallery img = galleryService.saveImage(gallery);
		return galleryService.updateImage(img, imgId);
	}
	
	@DeleteMapping("/delete/{imgId}")
	public ResponseEntity<String> deleteImage(@PathVariable(value = "imgId") Integer imgId){
		try {
			galleryService.deleteImage(imgId);
		} catch(Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
