package com.unla.oo2.grupo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unla.oo2.grupo2.entity.Admin;
import com.unla.oo2.grupo2.repository.IAdminRepository;

@Service
public class AdminService {

	@Autowired
	private IAdminRepository adminRepository;

	// Query
	public Admin getById(int id) {
		return adminRepository.getReferenceById(id);

	}

	public List<Admin> getAll() {
		return adminRepository.findAll();
	}

	// CUD
	public int create(Admin admin) {
		return adminRepository.save(admin).getId();
	}

	public void delete(int id) {
		if (id != 0)
			adminRepository.deleteById(id);
	}

}