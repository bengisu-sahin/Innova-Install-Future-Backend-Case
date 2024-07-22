package com.installfuturecase.InstallFutureBackendCase.controllers.TotalSpending;


import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.installfuturecase.InstallFutureBackendCase.business.abstracts.ScheduledJobsService;

@RestController
@RequestMapping("/totalSpending")
public class TotalSpendingController {

    private ScheduledJobsService scheduledJobsService;

    @Autowired
    public TotalSpendingController(ScheduledJobsService scheduledJobsService) {
        this.scheduledJobsService = scheduledJobsService;
    }

    @GetMapping("/lastDay")
    public BigDecimal calculateTotalTransactionAmountLastDay(@RequestParam(name = "username") String username) {
        return scheduledJobsService.calculateTotalTransactionAmountLastDay(username);
    }
    @GetMapping("/lastWeek")
    public BigDecimal calculateTotalTransactionAmountLastWeek(@RequestParam(name = "username") String username) {
        return scheduledJobsService.calculateTotalTransactionAmountLastWeek(username);
    }
    @GetMapping("/lastMonth")
    public BigDecimal calculateTotalTransactionAmountLastMonth(@RequestParam(name = "username") String username) {
        return scheduledJobsService.calculateTotalTransactionAmountLastMonth(username);
    }
    @GetMapping("/{username}")
    public BigDecimal getTotalSpendingByUsername(@PathVariable String username) {
        return scheduledJobsService.calculateTotalTransactionAmountLastDay(username);
    }

}
