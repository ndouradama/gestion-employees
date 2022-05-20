package com.premier.GestionEmployee.service;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeeRepository;

    public Optional<Employees> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }

    public Iterable<Employees> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }

    public Employees saveEmployee(Employees employee) {
        Employees savedEmployee = (Employees) employeeRepository.save(employee);
        return savedEmployee;
    }
}
