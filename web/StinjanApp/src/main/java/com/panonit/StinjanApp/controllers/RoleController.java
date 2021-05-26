package com.panonit.StinjanApp.controllers;

import java.util.List;
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

import com.panonit.StinjanApp.models.Role;
import com.panonit.StinjanApp.services.RoleService;

@RestController
@RequestMapping("role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@GetMapping("/list")
	public List<Role> allRoles(){
		return roleService.allRoles();
	}
	
	@GetMapping("/getById/{roleId}")
	public Role getById(@PathVariable(value = "roleId") Integer roleId){
		return roleService.getById(roleId);
	}
	
	@PostMapping("/save")
	public Role saveRole(@RequestBody Role role) {
		Role rol = roleService.saveRole(role);
		return rol;
	}
	
	@PutMapping("/update/{roleId}")
	public Role updateRole(@RequestBody Role role, @PathVariable(value = "roleId") Integer roleId) {
		Role rol = roleService.saveRole(role);
		return roleService.updateRole(rol, roleId);
	}
	
	@DeleteMapping("/delete/{roleId}")
	public ResponseEntity<String> deleteRole(@PathVariable(value = "roleId") Integer roleId){
		try {
			roleService.deleteRole(roleId);
		} catch(Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
