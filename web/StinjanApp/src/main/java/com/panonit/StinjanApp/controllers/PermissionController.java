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

import com.panonit.StinjanApp.models.Permission;
import com.panonit.StinjanApp.services.PermissionService;

@RestController
@RequestMapping("permission")
public class PermissionController {
	
	@Autowired
	PermissionService permissionService;
	
	@GetMapping("/list")
	public List<Permission> allPermissions(){
		return permissionService.allPermissions();
	}
	
	@GetMapping("/getById/{permissionId}")
	public Optional<Permission> getById(@PathVariable(value = "permissionId") Integer permissionId){
		return permissionService.getById(permissionId);
	}
	
	@PostMapping("/save")
	public Permission savePermission(@RequestBody Permission permission) {
		Permission perm = permissionService.savePermission(permission);
		return perm;
	}
	
	@PutMapping("/update/{permissionId}")
	public Permission updatePermission(@RequestBody Permission permission, @PathVariable(value = "permissionId") Integer permissionId) {
		Permission perm = permissionService.savePermission(permission);
		return permissionService.updatePermission(perm, permissionId);
	}
	
	@DeleteMapping("/delete/{permissionId}")
	public ResponseEntity<String> deletePermission(@PathVariable(value = "permissionId") Integer permissionId){
		try {
			permissionService.deletePermission(permissionId);
		} catch(Exception ex) {
			String errorMessage = ex.getMessage();
			System.out.println(errorMessage);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
		}
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
}
