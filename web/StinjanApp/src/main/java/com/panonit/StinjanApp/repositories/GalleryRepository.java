package com.panonit.StinjanApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panonit.StinjanApp.models.Gallery;

@Repository("galleryRepository")
public interface GalleryRepository extends JpaRepository<Gallery,Integer> {

}
