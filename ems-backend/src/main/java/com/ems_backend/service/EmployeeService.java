package com.ems_backend.service;

import com.ems_backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    public EmployeeDto createEmployee(EmployeeDto dto);
    public EmployeeDto getEmployee(Long id);
    public List<EmployeeDto> getAllEmployee();
    public EmployeeDto updateEmployee(Long id, EmployeeDto dto);
    public String deleteUser(Long id);
}
