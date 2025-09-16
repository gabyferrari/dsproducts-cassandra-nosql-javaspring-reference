package com.gabyferrari.dsproducts.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabyferrari.dsproducts.model.dto.DepartmentDTO;
import com.gabyferrari.dsproducts.model.entities.Department;
import com.gabyferrari.dsproducts.repositories.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	public List<DepartmentDTO> findAll() {
		List<Department> list = repository.findAll();
		return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
	}
}
