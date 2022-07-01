package com.premier.GestionEmployee.controller;

import com.premier.GestionEmployee.dto.Decaissement;
import com.premier.GestionEmployee.dto.Salaire;
import com.premier.GestionEmployee.model.Transactions;
import com.premier.GestionEmployee.service.TransactionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@Api(tags = "Webservice des transactions")
@RestController
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    //lister la liste
    @GetMapping("//user/transactions")
    @RolesAllowed("USER")
    public Iterable<Transactions> getTransactions() {
        return transactionService.getTransactions();
    }

    //moditier une transaction
    @PutMapping("/transaction/{id}")
    @RolesAllowed({"USER", "ADMIN"})
    public List<Transactions> updateTransaction(@PathVariable("id")Long id) {
        return transactionService.updateTransactions(id);
    }

   //recherche par id
    @GetMapping("/user/transactions/{id}")
    @RolesAllowed("USER")
    public Optional<Transactions> getTransaction(@PathVariable("id") Long id) {
        return transactionService.getTransaction(id);
    }

    //enregistrer une transaction: decaissement
    @PostMapping("/user/decaissement")
    @RolesAllowed("USER")
    public Transactions createDecaissement(@RequestBody()Decaissement decaissement) {
        return transactionService.saveDecaissement(decaissement);
    }
    @PostMapping("/user/salaire")
    @RolesAllowed("USER")
    public Transactions createSalaire(@RequestBody()Salaire salaire) {
        return transactionService.saveSalaire(salaire);}


    //enregistrer une transaction
//    @GetMapping("/test")
//    public Iterable<Transactions> testTransactions() {
//        return transactionService.test();
//    }

}
