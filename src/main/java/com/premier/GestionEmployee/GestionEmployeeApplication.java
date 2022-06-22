package com.premier.GestionEmployee;

import com.premier.GestionEmployee.model.Employees;
import com.premier.GestionEmployee.model.Trans_Type;
import com.premier.GestionEmployee.model.Transactions;
import com.premier.GestionEmployee.repository.EmployeesRepository;
import com.premier.GestionEmployee.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@AllArgsConstructor
public class GestionEmployeeApplication {

	private EmployeesRepository employeesRepository;
	private TransactionRepository transactionRepository;
	public static void main(String[] args) {

		SpringApplication.run(GestionEmployeeApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run() {
//		return args -> {
//			Employees directeur = Employees.builder().id(1).cin(1234).poste("Directeur").build();
//			directeur.setLastname("Mac");
//			directeur.setFirstname("Mac");
//			directeur.setAddresse("yoff");
//			directeur.setMail("mac@gmail.com");
//			directeur.setNum("770008899");
//			Employees directeur_adjoint = Employees.builder().id(2).cin(1235).poste("Directeur Adjoint").build();
//			directeur_adjoint.setFirstname("adama");
//			directeur_adjoint.setLastname("ndour");
//			directeur_adjoint.setNum("708456485");
//			directeur_adjoint.setAddresse("sicap");
//			directeur_adjoint.setMail("adama@gmail.com");
//			Employees secretaire = Employees.builder().id(3).cin(1236).poste("Secretaire").build();
//			secretaire.setMail("khady@gmail.com");
//			secretaire.setNum("764568521");
//			secretaire.setFirstname("khady");
//			secretaire.setLastname("diouf");
//			secretaire.setAddresse("parcelle");
//
//			Transactions transactions = Transactions.builder().id(1).transType(Trans_Type.SALAIRE).amont(12345).created_by("YAABA").employees(directeur).payement_date(new Date()).build();
//			Transactions transactions1 = Transactions.builder().id(2).transType(Trans_Type.DECAISSEMENT).amont(2036548).created_by("oumy").employees(secretaire).payement_date(new Date()).build();
//			Transactions transactions3 = Transactions.builder().id(3).transType(Trans_Type.SALAIRE).amont(12345).created_by("awa").employees(directeur_adjoint).payement_date(new Date()).build();
//			employeesRepository.save(directeur);
//			employeesRepository.save(directeur_adjoint);
//			employeesRepository.save(secretaire);
//
//			transactionRepository.save(transactions);
//			transactionRepository.save(transactions1);
//			transactionRepository.save(transactions3);
//		};
//	}

}
