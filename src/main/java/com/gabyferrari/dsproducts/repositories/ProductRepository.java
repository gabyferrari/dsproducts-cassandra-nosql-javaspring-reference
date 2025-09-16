package com.gabyferrari.dsproducts.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.gabyferrari.dsproducts.model.entities.Product;

public interface ProductRepository extends CassandraRepository<Product, UUID>{

}
