package com.premier.GestionEmployee.repository;

import com.premier.GestionEmployee.model.Status_type;
import com.premier.GestionEmployee.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository <Users , Long> {

    Users findByUsername(String username);

   // List<Users> findByStatus(Status_type status_user);
}
