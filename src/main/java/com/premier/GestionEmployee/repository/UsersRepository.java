package com.premier.GestionEmployee.repository;

import com.premier.GestionEmployee.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository <Users , Long> {

    Users findByUsername(String username);



}