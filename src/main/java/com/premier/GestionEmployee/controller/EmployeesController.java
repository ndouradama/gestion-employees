package com.premier.GestionEmployee.controller;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.model.Status_type;
import com.premier.GestionEmployee.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeesController {
    @Autowired
    private EmployeesService employeeService;

    @GetMapping("/employees")
    @RolesAllowed("USER")
    public Iterable<Employees> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employe/{id}")
    @RolesAllowed("USER")
    public Optional<Employees> getEmployee(@PathVariable("id") Long id) {
        return employeeService.getEmployee(id);
    }

    @PutMapping("/employee/{status_Type}")
    @RolesAllowed("ADMIN")
    public Optional<Employees> updateEmployee(@PathVariable("status_Type")Status_type status_Type) {
        return employeeService.updatestatus(status_Type);
    }
    @PostMapping("/employees")
    @RolesAllowed("ADMIN")
    public Employees createEmployee(@RequestBody() Employees employee) {
        return employeeService.saveEmployee(employee);
    }

//    @PutMapping("/employees/{status_Type}")
//    public List<Employees> updateEmployee(@PathVariable("status_Type")Status_type status_Type) {
//        return employeeService.updateStatus(status_Type);
//    }
//    @PutMapping("/employees/{status_Type}")
//    public Optional<Employees> getEmployee(@PathVariable("status_Type")Status_type status_Type ) {
//    return employeeService.getEmployee(status_Type);
//}


//    public void deleteEmployee(final Long id) {
//       employeeService.deleteEmployee(id);
//    }






}
