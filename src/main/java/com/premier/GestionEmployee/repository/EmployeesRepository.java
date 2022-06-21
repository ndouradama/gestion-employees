package com.premier.GestionEmployee.repository;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.model.Status_type;
import com.premier.GestionEmployee.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface EmployeesRepository extends JpaRepository <Employees , Long> {

    @Query(value = "select * from employees where status_type = ?1",nativeQuery = true)
     List<Employees> findByStatus_type(Status_type status_Type);

    @Query(value = "select * from employees where status_type = ?1",nativeQuery = true)
    Optional<Employees> updateStatus_type(Status_type status_Type);

    @Query(value = "select * from employees where cin = ?1",nativeQuery = true)
    Optional<Employees>  findByCin(int cin);




}
