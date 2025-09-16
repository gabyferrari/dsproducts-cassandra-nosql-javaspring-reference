package com.gabyferrari.dsproducts.services;

import java.util.Optional;
import java.util.UUID;

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
	
	private Product getById(UUID id) {
		Optional<Product> result = repository.findById(id);
		return result.orElseThrow(() -> new ResourceNotFoundException("Id não encontrado"));
	}
	
}
