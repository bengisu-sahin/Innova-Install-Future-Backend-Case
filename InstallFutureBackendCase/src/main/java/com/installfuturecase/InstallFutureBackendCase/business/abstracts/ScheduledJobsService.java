package com.installfuturecase.InstallFutureBackendCase.business.abstracts;

import java.math.BigDecimal;

public interface ScheduledJobsService {
    BigDecimal calculateTotalTransactionAmountLastWeek(String username);
    BigDecimal calculateTotalTransactionAmountLastDay(String username);
    BigDecimal calculateTotalTransactionAmountLastMonth(String username);
}
