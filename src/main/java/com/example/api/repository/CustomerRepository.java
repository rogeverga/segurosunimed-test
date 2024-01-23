package com.example.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.example.api.domain.Customer;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	Page<Customer> findAllByAddress(
			@Param("city") String city, @Param("federativeUnit") String federativeUnit, Pageable pageable
	);

	Page<Customer> findAll(
			@Param("email") String email, @Param("gender") String gender,
			@Param("name") String name, Pageable pageable
	);

}