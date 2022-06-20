package com.premier.GestionEmployee.service;

import com.premier.GestionEmployee.dto.Decaissement;
import com.premier.GestionEmployee.dto.Salaire;
import com.premier.GestionEmployee.model.*;
import com.premier.GestionEmployee.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.premier.GestionEmployee.service.EmployeesService;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private EmployeesService employeesService;

    public Optional<Transactions> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }

    public Iterable<Transactions> getTransactions() {
        return transactionRepository.findAll();
    }

    public Optional <Transactions> updateTransactions() {
       return transactionRepository.updateTransactions();
    }

    public Transactions saveTransactions(Transactions transactions) {
        Optional<Transactions> transactions1= transactionRepository.findById(transactions.getId()) ;
        if (transactions1.isPresent()){
            throw new RuntimeException("Cette transaction existe deja");
        }
//        Optional<Employees>present1= employeesService.getEmployee(transactions.getEmployees().getId());

      boolean present1 = employeesService.getEmployee(transactions.getEmployees().getId()).isPresent();
        if (!present1) {
            throw new RuntimeException("employées non existant");
        }
        return transactionRepository.save(transactions);
    }
    public Transactions saveDecaissement(Decaissement decaissement){
        Transactions transactions = new Transactions();
        transactions.setAmont(decaissement.getAmont());
        transactions.setEmployees(decaissement.getEmployees());
        transactions.setTransType(decaissement.getTransType());
        transactions.setDescription(decaissement.getDescription());
        transactions.setCreated_by(decaissement.getCreated_by());
        transactions.setPayement_date(decaissement.getPayement_date());
        transactions.setMounth(decaissement.getMounth());
//        9
        return transactionRepository.save(transactions);
    }

    public Transactions saveSalaire(Salaire salaire) {
        Transactions transactions = new Transactions();
        transactions.setAmont(salaire.getAmont());
        transactions.setEmployees(salaire.getEmployees());
        transactions.setTransType(salaire.getTransType());
        transactions.setCreated_by(salaire.getCreated_by());
        transactions.setPayement_date(salaire.getPayement_date());
        transactions.setMounth(salaire.getMounth());
        transactions.setStatuts(salaire.getStatuts());
        boolean present2 = salaire.getTransType()==Trans_Type.SALAIRE && !transactions.getDescription().equals("");
        if (present2){
            throw new RuntimeException("salaire ne doit pas contenir de description");
        }

        boolean present3 = salaire.getStatuts()==Statuts.PAYEMENT_COMPLETE && salaire.getMounth().equals(salaire.getMounth());
        if (present3){
            throw new RuntimeException("erreur de payement");
        }


//        public List<Transactions> findByStatuts() ;{
//        }
//        public Iterable<Transactions> findByStatutsAndMounth(Statuts.valueOf(String.valueOf(Statuts.PAYEMENT_COMPLETE)) , Mounth.values());{
//        }
        return transactionRepository.save(transactions);
    }

//    public Iterable<Transactions> test() {
//
//        return transactionRepository.findByStatutsAndMounth(Statuts.PAYEMENT_COMPLETE , Mounth.AOUT);
//    }
}















