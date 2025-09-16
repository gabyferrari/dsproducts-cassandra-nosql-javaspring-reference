package com.gabyferrari.dsproducts.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabyferrari.dsproducts.model.dto.ProductDTO;
import com.gabyferrari.dsproducts.model.entities.Product;
import com.gabyferrari.dsproducts.repositories.ProductRepository;
import com.gabyferrari.dsproducts.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public ProductDTO findById(UUID id) {
		Product entity = getById(id);
		return new ProductDTO(entity);
	}
	
	public List<ProductDTO> findByDepartment(String department) {
		List<Product> list;
		if ("".equals(department)) {
			list = repository.findAll();
		}
		else {
			list = repository.findByDepartment(department);
		}
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
	
	private Product getById(UUID id) {
		Optional<Product> result = repository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
	}
	
}
