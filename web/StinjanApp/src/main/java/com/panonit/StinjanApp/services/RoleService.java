package com.panonit.StinjanApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.panonit.StinjanApp.models.Role;
import com.panonit.StinjanApp.repositories.RoleRepository;

@Service("roleService")
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	public List<Role> allRoles(){
		return roleRepository.findAll();
	}
	
	public Optional<Role> getById(Integer roleId){
		return roleRepository.findById(roleId);
	}
	
	public Role saveRole(Role role) {
		Role rol = roleRepository.save(role);
		return rol;
	}
	
	public Role updateRole(Role role, Integer roleId) {
		role.setRoleId(roleId);
		return roleRepository.save(role);
	}
	
	public void deleteRole(Integer roleId) {
		roleRepository.deleteById(roleId);
	}
}
