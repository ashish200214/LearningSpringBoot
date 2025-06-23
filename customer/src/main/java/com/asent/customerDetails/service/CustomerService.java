package com.asent.customerDetails.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.asent.customerDetails.dto.CustomerDTO;
import com.asent.customerDetails.entity.CustomerEntity;
import com.asent.customerDetails.mapper.MapperClass;
import com.asent.customerDetails.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService{
	static int pageNo=1;
	@Autowired
	CustomerRepository repository;
	@Override
	public void saveCustomer(CustomerDTO dto) {
		repository.save(MapperClass.customerFromDtoToEntity(dto));	
	}
	
	@Override
	public List<CustomerDTO> getAllCustomerDetails(){
		List<CustomerEntity> ent=  repository.findAll();
		List<CustomerDTO> dtoList = new ArrayList<>();
		for(CustomerEntity entity : ent) {	
			dtoList.add(MapperClass.customerFromEntityToDto(entity));
		}
		return dtoList;
	}
	@Override
	public CustomerEntity searchUser(String option, String enteredDetails) {
	    return switch (option) {
	        case "name" -> repository.findByName(enteredDetails).orElse(null); // Return null if user doesn't exist
	        case "whatsappNo" -> repository.findByWhatappNo(enteredDetails).orElse(null); // Return null if user doesn't exist
	        default -> null; // Return null for invalid option
	    };
	}

    public void deleteUserByID(Integer id) {
		repository.deleteById(id);


	}

	public CustomerEntity findCustomerById(Integer id){
		Optional<CustomerEntity> optional = repository.findById(id);
		if(optional.isPresent()){
			return optional.get();
		}
		return null;
	}

	
	public List<CustomerEntity>sortByAscending(int pageNo){
		Sort sort = Sort.by("name").ascending();
		PageRequest req = PageRequest.of(pageNo-1,5,sort);

		Page<CustomerEntity> page = repository.findAll(req);
		pageNo++;
		return page.getContent();
	}

}
