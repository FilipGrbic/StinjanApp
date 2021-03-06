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
	public Gallery getById(@PathVariable(value = "imgId") Integer imgId){
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
	
	@GetMapping(value = "/showGalleryImage/{imgId}")
	public void showGalleryImage(@PathVariable Integer imgId, HttpServletResponse response,
			HttpServletRequest request) {

		try {
			Gallery gallery = galleryService.getById(imgId);
			if(gallery.getImg() != null) {
				response.getOutputStream().write(gallery.getImg());
				response.getOutputStream().close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value = "/uploadGalleryImage/{imgId}")
	public ResponseEntity<String> uploadGalleryImage(@RequestPart(value = "image") MultipartFile file,
			@PathVariable(value = "imgId") Integer imgId, HttpServletResponse response,
			HttpServletRequest request){
		if (!file.isEmpty())
			try {
				byte[] bytes = file.getBytes();
				
				Gallery gallery = galleryService.getById(imgId);
				gallery.setImg(bytes);
				galleryService.saveImage(gallery);

			} catch (Exception e) {
				e.printStackTrace();
				return new ResponseEntity<String>("Upload failed", HttpStatus.BAD_REQUEST);
			}
		return new ResponseEntity<String>("Upload success", HttpStatus.OK);
	}
}
