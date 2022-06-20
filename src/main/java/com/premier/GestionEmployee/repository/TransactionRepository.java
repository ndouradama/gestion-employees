package com.premier.GestionEmployee.repository;

import com.premier.GestionEmployee.model.Mounth;
import com.premier.GestionEmployee.model.Statuts;
import com.premier.GestionEmployee.model.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static org.hibernate.loader.Loader.SELECT;

@Repository
public interface TransactionRepository extends JpaRepository <Transactions , Long> {


//        public List<Transactions> findByStatuts(Statuts statuts);
//
        public List<Transactions> findByStatutsAndMounth(Statuts statuts , Mounth mounth);

        @Query(value = "select * from transaction WHERE cout = :cout",nativeQuery = true)
        Optional<Transactions> updateTransactions();


//        @Query(SELECT Transactions FROM Statuts statuts   where Transactio = ?1 and u.lastname = ?2)
//        public Iterable<Transactions> findByStatutsJPQL();
//objet  transact type transaction




}
