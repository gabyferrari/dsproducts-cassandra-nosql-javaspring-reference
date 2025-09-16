package com.gabyferrari.dsproducts.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabyferrari.dsproducts.model.dto.DepartmentDTO;
import com.gabyferrari.dsproducts.model.entities.Department;
import com.gabyferrari.dsproducts.repositories.DepartmentRepository;
import com.gabyferrari.dsproducts.services.exceptions.ResourceNotFoundException;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository repository;
	
	public List<DepartmentDTO> findAll() {
		List<Department> list = repository.findAll();
		return list.stream().map(x -> new DepartmentDTO(x)).collect(Collectors.toList());
	}
	
	public DepartmentDTO findById(UUID id) {
		Optional<Department> result = repository.findById(id);
		Department entity = result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
		return new DepartmentDTO(entity);
	}
	
	public DepartmentDTO insert(DepartmentDTO dto) {
		Department entity = new Department();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new DepartmentDTO(entity);
	}

	private void copyDtoToEntity(DepartmentDTO dto, Department entity) {
		entity.setId(UUID.randomUUID());
		entity.setName(dto.getName());
	}
	
}
