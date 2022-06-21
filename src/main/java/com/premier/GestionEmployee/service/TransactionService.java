package com.premier.GestionEmployee.service;

import com.premier.GestionEmployee.dto.Decaissement;
import com.premier.GestionEmployee.dto.Salaire;
import com.premier.GestionEmployee.model.*;
import com.premier.GestionEmployee.repository.EmployeesRepository;
import com.premier.GestionEmployee.repository.TransactionRepository;
import com.premier.GestionEmployee.repository.UsersRepository;
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

    @Autowired
    private JwtUserDetailsService userService;

    @Autowired
    EmployeesRepository employeesRepository;
    @Autowired
    UsersRepository usersRepository;
    private Users users;
    private Employees employees;

    public Optional<Transactions> getTransaction(Long id) {
        return transactionRepository.findById(id);
    }

    public Iterable<Transactions> getTransactions() {
        return transactionRepository.findAll();
    }

    public List <Transactions> updateTransactions(Long id) {
       return transactionRepository.updateTransactions(id);
    }

    public Transactions saveDecaissement(Decaissement decaissement){
        Transactions transactions = new Transactions();
        Optional<Transactions> transactions1= transactionRepository.findById(transactions.getId()) ;
        if (transactions1.isPresent()){
            throw new RuntimeException("Cette transaction existe deja");
        }
        Users user = usersRepository.findById(decaissement.getCreated_by())
                .orElseThrow(() -> new RuntimeException("User not exist"));
        if (user.getStatus_user() == Status_type.INACTIF)  {
            throw new RuntimeException("user doit pas faire de transaction");
        }
        Employees employees = employeesRepository.findById(decaissement.getEmployees())
                .orElseThrow(() ->new RuntimeException("employee not exit"));
        if(employees.getStatus_Type()== Status_type.INACTIF){
            throw new RuntimeException("cet employée ne peux pas bénéficier d'un transaction");
        }

        boolean present1 = employeesService.getEmployee(employees.getId()).isPresent();
        if (!present1) {
            throw new RuntimeException("employées non existant");
        }
        transactions.setAmont(decaissement.getAmont());
        transactions.setEmployees(employees);
        transactions.setTransType(decaissement.getTransType());
        transactions.setDescription(decaissement.getDescription());
        transactions.setCreated_by(user);
        transactions.setPayement_date(decaissement.getPayement_date());
        transactions.setMounth(decaissement.getMounth());


        return transactionRepository.save(transactions);
    }

    public Transactions saveSalaire(Salaire salaire) {
        Transactions transactions = new Transactions();
        Optional<Transactions> transactions1= transactionRepository.findById(transactions.getId()) ;
        if (transactions1.isPresent()){
            throw new RuntimeException("Cette transaction existe deja");
        }
        Users user = usersRepository.findById(salaire.getCreated_by())
                .orElseThrow(() -> new RuntimeException("User not exist"));
        if (user.getStatus_user() == Status_type.INACTIF)  {
            throw new RuntimeException("user doit pas faire de transaction");
        }
        Employees employees = employeesRepository.findById(salaire.getEmployees())
                .orElseThrow(()->  new RuntimeException("employee not exit"));
        if(employees.getStatus_Type()== Status_type.INACTIF){
            throw new RuntimeException("cet employée ne peux pas bénéficier d'un transaction");
        }
        boolean present1 = employeesService.getEmployee(employees.getId()).isPresent();
        if (!present1) {
            throw new RuntimeException("employées non existant");
        }

        if (salaire.getStatuts()==Statuts.PAYEMENT_COMPLETE && salaire.getMounth().equals(salaire.getMounth())){
            throw new RuntimeException("erreur de payement");
        }
        transactions.setAmont(salaire.getAmont());
        transactions.setEmployees(employees);
        transactions.setTransType(salaire.getTransType());
        transactions.setCreated_by(user);
        transactions.setPayement_date(salaire.getPayement_date());
        transactions.setMounth(salaire.getMounth());
        transactions.setStatuts(salaire.getStatuts());
        return transactionRepository.save(transactions);
    }

}















