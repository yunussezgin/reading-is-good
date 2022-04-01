package com.yunus.readingisgood.service.impl;

import org.springframework.stereotype.Service;

import com.yunus.readingisgood.entity.Customer;
import com.yunus.readingisgood.repository.CustomerRepository;
import com.yunus.readingisgood.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public void createCustomer() {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer retrieveCustomer(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
