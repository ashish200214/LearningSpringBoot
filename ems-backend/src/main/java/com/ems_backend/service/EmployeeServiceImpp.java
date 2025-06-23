package com.ems_backend.service;
import java.util.List;
import java.util.stream.Collectors;

import com.ems_backend.dto.EmployeeDto;
import com.ems_backend.entity.Employee;
import com.ems_backend.mapper.EmployeeMapper;
import com.ems_backend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.ems_backend.exception.*;
import org.springframework.stereotype.Service;

@Service

public class EmployeeServiceImpp implements  EmployeeService{

    @Autowired
    EmployeeRepository repository;
    @Override
    public EmployeeDto createEmployee(EmployeeDto dto) {
        //checked working fine.
        repository.save(EmployeeMapper.employeeDtoToEmployee(dto));
        return dto;
    }

    @Override
    public EmployeeDto getEmployee(Long id) {
        return EmployeeMapper.employeeToEmployeeDto(repository.findById(id).orElseThrow(()->new ResourceNotFound("User doesn't exist...")));


    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        //checked working fine.
        List<Employee> lis = repository.findAll();
        return lis.stream().map(EmployeeMapper::employeeToEmployeeDto).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto) {
        Employee emp= repository.findById(id).orElseThrow(()->new ResourceNotFound("Employee Doesn;t exist..."));
        emp.setFirstName(dto.getFirstName());
        emp.setLastName(dto.getLastName());
        emp.setEmail(dto.getEmail());
        repository.save(emp);
        return EmployeeMapper.employeeToEmployeeDto(emp);
    }

    @Override
    public String deleteUser(Long id) {
       Employee e =  repository.findById(id).orElseThrow(()->new ResourceNotFound("User doesn't exist..."));
        repository.delete(e);
        return "User Deleted Successfully...";
    }




}
