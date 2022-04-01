package com.yunus.readingisgood.service;

import com.yunus.readingisgood.entity.Customer;

public interface CustomerService {

	void createCustomer();

	Customer retrieveCustomer(Long id);

}
