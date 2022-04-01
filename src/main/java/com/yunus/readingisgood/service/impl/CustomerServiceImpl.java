package com.yunus.readingisgood.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.yunus.readingisgood.dto.request.CustomerCreate;
import com.yunus.readingisgood.entity.Customer;
import com.yunus.readingisgood.exception.NotFoundException;
import com.yunus.readingisgood.repository.CustomerRepository;
import com.yunus.readingisgood.service.CustomerService;
import com.yunus.readingisgood.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer createCustomer(CustomerCreate customerCreate) {
		log.info("CustomerService -> createCustomer started!");
		Customer customer = new Customer();
		BeanUtils.copyProperties(customerCreate, customer);
		customer = customerRepository.save(customer);
		log.info("CustomerService -> createCustomer completed!");
		return customer;
	}

	@Override
	public Customer retrieveCustomer(Long id) {
		log.info("CustomerService -> retrieveCustomer started! id:{}", id);
		Customer customer = customerRepository.findById(id).orElseThrow(
				() -> new NotFoundException(String.format(Constants.CUSTOMER_NOT_FOUND_EXCEPTION_MESSAGE, id)));
		log.info("CustomerService -> retrieveCustomer completed!");
		return customer;
	}

}
