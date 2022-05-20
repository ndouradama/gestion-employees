package com.premier.GestionEmployee.repository;

import com.premier.GestionEmployee.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeesRepository extends JpaRepository <Employees , Long> {

}
