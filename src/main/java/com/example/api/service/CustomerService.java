package com.example.api.service;

import java.util.Optional;

import com.example.api.client.rest.viacep.ViaCepRestClient;
import com.example.api.domain.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService {

	private CustomerRepository repository;

	@Autowired
	private ViaCepRestClient viaCepRestClient;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	public Customer create(Customer customer) throws Exception {
		for (Address address : customer.getAddresses()) {
			Address returnedAddress = viaCepRestClient.getAddressByZipCode(address.getZipCode());

			address.setCity(returnedAddress.getCity());
			address.setCustomer(customer);
			address.setFederativeUnit(returnedAddress.getFederativeUnit());
			address.setNeighborhood(returnedAddress.getNeighborhood());
			address.setStreet(returnedAddress.getStreet());
		}

		return repository.save(customer);
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	public Page<Customer> findAllByAddress(String city, String federativeUnit, PageRequest pageRequest) {
		return repository.findAllByAddress(city, federativeUnit, pageRequest);
	}

	public Page<Customer> findAll(String email, String gender, String name, PageRequest pageRequest) {
		return repository.findAll(email, gender, name, pageRequest);
	}

	public Optional<Customer> findById(Long id) {
		return repository.findById(id);
	}

	public Customer update(Customer customer) throws Exception {
		for (Address address : customer.getAddresses()) {
			Address returnedAddress = viaCepRestClient.getAddressByZipCode(address.getZipCode());

			address.setCity(returnedAddress.getCity());
			address.setCustomer(customer);
			address.setFederativeUnit(returnedAddress.getFederativeUnit());
			address.setNeighborhood(returnedAddress.getNeighborhood());
			address.setStreet(returnedAddress.getStreet());
		}

		return repository.save(customer);
	}

}