package com.panonit.StinjanApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.models.Gallery;
import com.panonit.StinjanApp.repositories.GalleryRepository;

@Service("galleryService")
public class GalleryService {
	
	@Autowired
	GalleryRepository galleryRepository;
	
	public List<Gallery> allImages(){
		return galleryRepository.findAll();
	}
	
	public Optional<Gallery> getById(Integer imgId){
		return galleryRepository.findById(imgId);
	}
	
	public Gallery saveImage(Gallery gallery) {
		Gallery img = galleryRepository.save(gallery);
		return img;
	}
	
	public Gallery updateImage(Gallery newGallery, Integer imgId) {
		newGallery.setImgId(imgId);
		return galleryRepository.save(newGallery);
	}
	
	public void deleteImage(Integer imgId) {
		galleryRepository.deleteById(imgId);
	}
}
