package com.premier.GestionEmployee.repository;

import com.premier.GestionEmployee.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository <Transactions , Long> {
}
