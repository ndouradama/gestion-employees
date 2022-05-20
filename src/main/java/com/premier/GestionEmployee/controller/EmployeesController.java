package com.premier.GestionEmployee.controller;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {
    @Autowired
    private EmployeesService employeeService;

    @GetMapping("/employees")
    public Iterable<Employees> getEmployees() {
        return employeeService.getEmployees();
    }



    @PostMapping("/employees")
    public Employees createEmployee(@RequestBody() Employees employee) {
        return employeeService.saveEmployee(employee);
    }



}
