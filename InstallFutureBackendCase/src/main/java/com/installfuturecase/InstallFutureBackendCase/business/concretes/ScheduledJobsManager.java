package com.installfuturecase.InstallFutureBackendCase.business.concretes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.installfuturecase.InstallFutureBackendCase.business.abstracts.ScheduledJobsService;
import com.installfuturecase.InstallFutureBackendCase.dataAcces.abstracts.ITransactionsRepository;

@Component
public class ScheduledJobsManager implements ScheduledJobsService {
    private final ITransactionsRepository transactionRepository;

    @Autowired
    public ScheduledJobsManager(ITransactionsRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Scheduled(fixedRate = 60000)
    public BigDecimal calculateTotalTransactionAmountLastWeek(String username) {
        LocalDate startDate = LocalDate.now().minus(7, ChronoUnit.DAYS); 
        LocalDate endDate = LocalDate.now();
        BigDecimal totalTransactionAmount=BigDecimal.ZERO;
        System.out.println("Son 1 hafta toplam harcama miktarı: " + totalTransactionAmount);
        totalTransactionAmount = transactionRepository.sumTransactionAmountByTransactionDateBetween(username,startDate, endDate);
        System.out.println("Son 1 haftadaki toplam harcama miktarı: " + totalTransactionAmount);
        return totalTransactionAmount;
    }

    @Scheduled(fixedRate = 60000)
    public BigDecimal calculateTotalTransactionAmountLastDay(String username) {
        LocalDate currentDate = LocalDate.now(); 
        LocalDate previousDate = currentDate.minusDays(1); 
        BigDecimal totalTransactionAmount;
        totalTransactionAmount = transactionRepository.sumTransactionAmountByTransactionDateBetween(username,previousDate,currentDate);
        System.out.println("Son 1 günlük toplam harcama miktarı: " + totalTransactionAmount);
        return totalTransactionAmount;
    }

    @Scheduled(fixedRate = 60000)
    public BigDecimal calculateTotalTransactionAmountLastMonth(String username) {
        LocalDate currentDate = LocalDate.now(); 
        LocalDate previousDate = currentDate.minusDays(30); 
        BigDecimal totalTransactionAmount=BigDecimal.ZERO;
        System.out.println("Son 1 aylık toplam harcama miktarı: " + totalTransactionAmount);
        totalTransactionAmount = transactionRepository.sumTransactionAmountByTransactionDateBetween(username,previousDate,currentDate);
        System.out.println("Son 1 aylık toplam harcama miktarı: " + totalTransactionAmount);
        return totalTransactionAmount;
    }
   
}
