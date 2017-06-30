package com.webapplication.dao.jpaRepository;
<<<<<<< HEAD
import com.webapplication.entity.ParentEntity;
=======

<<<<<<< HEAD
=======
import com.webapplication.entity.ParentEntity;
>>>>>>> add forgotten file
>>>>>>> add forgotten file
import com.webapplication.entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

<<<<<<< HEAD
    TransactionEntity findTransactionById(Integer id);
=======
<<<<<<< HEAD
>>>>>>> add forgotten file

=======
    TransactionEntity findTransactionById(Integer id);
>>>>>>> add forgotten file
}