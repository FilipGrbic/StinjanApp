package com.panonit.StinjanApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.panonit.StinjanApp.models.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role,Integer>{

}
