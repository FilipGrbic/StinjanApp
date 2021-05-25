package com.panonit.StinjanApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panonit.StinjanApp.models.Permission;

@Repository("permissionRepository")
public interface PermissionRepository extends JpaRepository<Permission,Integer>{

}
