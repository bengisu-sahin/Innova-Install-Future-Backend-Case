package com.installfuturecase.InstallFutureBackendCase.dataAcces.abstracts;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.installfuturecase.InstallFutureBackendCase.entities.Transaction;

@Repository
public interface ITransactionsRepository extends JpaRepository<Transaction, Integer> {
    Optional<Transaction> findById(Integer id);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.transaction_date BETWEEN :startDate AND :endDate AND t.user.name = :username ")
    BigDecimal sumTransactionAmountByTransactionDateBetween(@Param("username") String username,LocalDate startDate, LocalDate endDate);

    @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.user.name = :username")
    BigDecimal getTotalSpendingByUsername(@Param("username") String username);

}
