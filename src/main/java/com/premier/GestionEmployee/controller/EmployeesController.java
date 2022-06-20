package com.premier.GestionEmployee.controller;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.model.Status_type;
import com.premier.GestionEmployee.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeesController {
    @Autowired
    private EmployeesService employeeService;

    @GetMapping("/employees")
    public Iterable<Employees> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employe/{id}")
    public Optional<Employees> getEmployee(@PathVariable("id") Long id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees/{statut}")
    public List<Employees> getEmployee(@PathVariable("statut")Status_type status_Type) {
        return employeeService.getEmployee(status_Type);
    }

    @PutMapping("/employees/{statut}")
    public List<Employees> updateEmployee(@PathVariable("statut")Status_type status_Type) {
        return employeeService.updateStatus(status_Type);
    }


//    public void deleteEmployee(final Long id) {
//       employeeService.deleteEmployee(id);
//    }


    @PostMapping("/employees")
    public Employees createEmployee(@RequestBody() Employees employee) {
        return employeeService.saveEmployee(employee);
    }



}
