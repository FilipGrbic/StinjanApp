package com.panonit.StinjanApp.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.models.Permission;
import com.panonit.StinjanApp.repositories.PermissionRepository;

@Service("permissionService")
public class PermissionService {
	
	@Autowired
	PermissionRepository permissionRepository;
	
	public List<Permission> allPermissions(){
		return permissionRepository.findAll();
	}
	
	public Permission getById(Integer permissionId){
		return permissionRepository.findById(permissionId).get();
	}
	
	public Permission savePermission(Permission permission) {
		return permissionRepository.save(permission);
	}
	
	public Permission updatePermission(Permission permission, Integer permissionId) {
		permission.setPermissionId(permissionId);
		return permissionRepository.save(permission);
	}
	
	public void deletePermission(Integer permissionId) {
		permissionRepository.deleteById(permissionId);
	}
}
