package com.ems_backend.mapper;

import com.ems_backend.entity.Employee;
import com.ems_backend.dto.EmployeeDto;;
public class EmployeeMapper {
    private  EmployeeMapper(){

    }
    public static Employee employeeDtoToEmployee(EmployeeDto dto){
        Employee e = new Employee();
        e.setId(dto.getId());
        e.setEmail(dto.getEmail());
        e.setFirstName(dto.getFirstName());
        e.setLastName(dto.getLastName());
        return e;
    }

    public static EmployeeDto employeeToEmployeeDto(Employee emp){
        EmployeeDto dto = new EmployeeDto();
        dto.setId(emp.getId());
        dto.setFirstName(emp.getFirstName());
        dto.setLastName(emp.getLastName());
        dto.setEmail(emp.getEmail());

        return dto;

    }
}
