package com.asent.customerDetails.service;

import java.util.List;

import com.asent.customerDetails.dto.CustomerDTO;
import com.asent.customerDetails.entity.CustomerEntity;

public interface ICustomerService {
	void saveCustomer(CustomerDTO dto);
	public List<CustomerDTO> getAllCustomerDetails();
	CustomerEntity searchUser(String option, String enteredDetails);
}
