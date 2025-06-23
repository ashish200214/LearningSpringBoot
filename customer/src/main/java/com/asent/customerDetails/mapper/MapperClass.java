package com.asent.customerDetails.mapper;

import com.asent.customerDetails.dto.CustomerDTO;
import com.asent.customerDetails.entity.CustomerEntity;


public class MapperClass {

	public static CustomerDTO customerFromEntityToDto(CustomerEntity entity) {
		
		CustomerDTO dto = new CustomerDTO();
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setAddress(entity.getAddress());
		dto.setWhatappNo(entity.getWhatappNo());
		dto.setRequirements(entity.getRequirements());
		
		return dto;
	}
	
	public static CustomerEntity customerFromDtoToEntity(CustomerDTO dto) {
		CustomerEntity entity = new CustomerEntity();
		entity.setId(dto.getId());
		entity.setName(dto.getName());
		entity.setAddress(dto.getAddress());
		entity.setRequirements(dto.getRequirements());
		entity.setWhatappNo(dto.getWhatappNo());
		
		return entity;
	}
}
