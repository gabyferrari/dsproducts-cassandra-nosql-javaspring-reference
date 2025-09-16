package com.gabyferrari.dsproducts.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.gabyferrari.dsproducts.model.entities.Department;

public interface DepartmentRepository extends CassandraRepository<Department, UUID>{

}
