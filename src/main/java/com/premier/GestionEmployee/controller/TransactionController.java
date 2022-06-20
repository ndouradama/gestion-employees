package com.premier.GestionEmployee.controller;

import com.premier.GestionEmployee.dto.Decaissement;
import com.premier.GestionEmployee.dto.Salaire;
import com.premier.GestionEmployee.model.Transactions;
import com.premier.GestionEmployee.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    //lister la liste
    @GetMapping("/transactions")
    public Iterable<Transactions> getTransactions() {
        return transactionService.getTransactions();
    }

    //moditier une transaction
    @PutMapping("/transaction")
    public Optional<Transactions> updateTransaction() {
        return transactionService.updateTransactions();
    }

   //recherche par id
    @GetMapping("/transactions/{id}")
    public Optional<Transactions> getTransaction(@PathVariable("id") Long id) {
        return transactionService.getTransaction(id);
    }

    //enregistrer une transaction: decaissement
    @PostMapping("/decaissement")
    public Transactions createDecaissement(@RequestBody()Decaissement decaissement) {
        return transactionService.saveDecaissement(decaissement);
    }
    @PostMapping("/salaire")
    public Transactions createSalaire(@RequestBody()Salaire salaire) {
        return transactionService.saveSalaire(salaire);}


    //enregistrer une transaction
//    @GetMapping("/test")
//    public Iterable<Transactions> testTransactions() {
//        return transactionService.test();
//    }

}
