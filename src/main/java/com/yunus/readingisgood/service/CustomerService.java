package com.yunus.readingisgood.service;

import com.yunus.readingisgood.dto.request.CustomerCreate;
import com.yunus.readingisgood.entity.Customer;

public interface CustomerService {

	Customer createCustomer(CustomerCreate customerCreate);

	Customer retrieveCustomer(Long id);

}
