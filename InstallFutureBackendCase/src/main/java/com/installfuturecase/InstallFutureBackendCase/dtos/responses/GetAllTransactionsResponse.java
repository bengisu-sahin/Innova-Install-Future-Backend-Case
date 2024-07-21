package com.installfuturecase.InstallFutureBackendCase.dtos.responses;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTransactionsResponse {
    private int id;

    private BigDecimal amount;

    private String description;
    private String transaction_type;

    private LocalDate transaction_date;

    private LocalDate created_at;

    private LocalDate updated_at;

    private String email;
    private String name;
}
