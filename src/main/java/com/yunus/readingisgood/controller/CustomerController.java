package com.yunus.readingisgood.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yunus.readingisgood.dto.request.CustomerCreate;
import com.yunus.readingisgood.entity.Customer;
import com.yunus.readingisgood.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService customerService;

	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Customer> createCustomer(@RequestBody CustomerCreate customerCreate) {
		Customer customer = customerService.createCustomer(customerCreate);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Customer> retrieveCustomer(@PathVariable("id") Long id) {
		Customer customer = customerService.retrieveCustomer(id);
		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

}
