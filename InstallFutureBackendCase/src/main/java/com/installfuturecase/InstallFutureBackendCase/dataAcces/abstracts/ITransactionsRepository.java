package com.installfuturecase.InstallFutureBackendCase.dataAcces.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.installfuturecase.InstallFutureBackendCase.entities.Transaction;

@Repository
public interface ITransactionsRepository extends JpaRepository<Transaction, Integer> {
    
}
