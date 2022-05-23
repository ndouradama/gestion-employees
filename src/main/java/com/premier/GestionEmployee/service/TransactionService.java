package com.premier.GestionEmployee.service;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.model.Transactions;
import com.premier.GestionEmployee.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Optional<Transactions> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }

    public Iterable<Transactions> getTransactions() {
        return transactionRepository.findAll();
    }

    public void deleteTransactions(final Long id) {
        transactionRepository.deleteById(id);
    }

    public Transactions saveTransactions(Transactions transactions) {
        return transactionRepository.save(transactions);
    }
}


















