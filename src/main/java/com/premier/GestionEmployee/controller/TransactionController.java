package com.premier.GestionEmployee.controller;

import com.premier.GestionEmployee.model.Transactions;
import com.premier.GestionEmployee.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public Iterable<Transactions> getTransactions() {
        return transactionService.getTransactions();
    }


    @PostMapping("/transactions")
    public Transactions createTransactions(@RequestBody() Transactions transactions) {
        return transactionService.saveTransactions(transactions);
    }

}
