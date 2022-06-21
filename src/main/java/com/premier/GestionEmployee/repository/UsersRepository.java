package com.premier.GestionEmployee.repository;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.model.Status_type;
import com.premier.GestionEmployee.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository <Users , Long> {

    Users findByUsername(String username);
    @Query(value = "select * from users where mail = ?1",nativeQuery = true)
    Optional<Users> findByMail(String mail);

   // List<Users> findByStatus(Status_type status_user);
}
