package com.premier.GestionEmployee.service;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.model.Status_type;
import com.premier.GestionEmployee.model.Transactions;
import com.premier.GestionEmployee.repository.EmployeesRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesService {

    @Autowired
    private EmployeesRepository employeeRepository;

    public Optional<Employees> getEmployee(final Long id) {
        return employeeRepository.findById(id);
    }


    public List<Employees> getEmployee(Status_type status_Type) {
        return employeeRepository.findByStatus_type(status_Type);
    }

//    public List <Employees> updateStatus(Status_type status_Type){
//        return employeeRepository.updateStatus_type(status_Type);
//    }
    public Optional<Employees> updatestatus(Status_type status_Type){
        return employeeRepository.updateStatus_type(status_Type);
    }


    public Iterable<Employees> getEmployees() {
        return employeeRepository.findAll();
    }

    public void deleteEmployee(final Long id) {
        employeeRepository.deleteById(id);
    }

    public Employees saveEmployee(Employees employee) {
       Optional <Employees> employees = employeeRepository.findByCin(employee.getCin());
        if(employees.isPresent()){
            throw new RuntimeException("cet employée exit déja");
        }
        Employees savedEmployee = (Employees) employeeRepository.save(employee);

        return savedEmployee;
    }
}
