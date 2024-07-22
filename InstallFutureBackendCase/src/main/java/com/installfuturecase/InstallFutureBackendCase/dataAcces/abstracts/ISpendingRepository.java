// package com.installfuturecase.InstallFutureBackendCase.dataAcces.abstracts;

// import com.installfuturecase.InstallFutureBackendCase.entities.Transaction;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
// import org.springframework.stereotype.Repository;

// import java.math.BigDecimal;
// import java.time.LocalDate;

// @Repository
// public interface ISpendingRepository extends JpaRepository<Transaction, Integer> {
//     @Query("SELECT SUM(t.amount) FROM Transaction t WHERE t.user.name = ?1")
//     BigDecimal getTotalSpendingByUsername(String name);

//     @Query("SELECT SUM(t.amount) FROM transaction t WHERE t.transaction_date BETWEEN :startDate AND :endDate")
//     BigDecimal sumTransactionAmountByTransactionDateBetween(LocalDate startDate, LocalDate endDate);
// }
