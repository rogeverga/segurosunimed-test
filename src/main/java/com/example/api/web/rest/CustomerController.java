package com.example.api.web.rest;

import com.example.api.constant.StringConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.api.domain.Customer;
import com.example.api.service.CustomerService;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer create(@RequestBody @Valid Customer customer) throws Exception {
		return service.create(customer);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		service.deleteById(id);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Customer> findAll(
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String gender,
			@RequestParam(required = false, defaultValue = StringConstant.NUMBER_10) Integer limit,
			@RequestParam(required = false) String name,
			@RequestParam(required = false, defaultValue = StringConstant.NUMBER_0) Integer offset
	) {
		return service.findAll(email, gender, name, PageRequest.of(offset, limit));
	}

	@GetMapping(value = "/address", produces = MediaType.APPLICATION_JSON_VALUE)
	public Page<Customer> findAllByAddress(
			@RequestParam(required = false) String city,
			@RequestParam(required = false) String federativeUnit,
			@RequestParam(required = false, defaultValue = StringConstant.NUMBER_10) Integer limit,
			@RequestParam(required = false, defaultValue = StringConstant.NUMBER_0) Integer offset
	) {
		return service.findAllByAddress(city, federativeUnit, PageRequest.of(offset, limit));
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer findById(@PathVariable Long id) {
		return
			service
				.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Customer update(@RequestBody @Valid Customer customer) throws Exception {
		return service.update(customer);
	}

}
