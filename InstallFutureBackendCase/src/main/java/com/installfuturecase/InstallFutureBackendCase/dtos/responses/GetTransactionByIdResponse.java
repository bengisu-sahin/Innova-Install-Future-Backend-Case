package com.installfuturecase.InstallFutureBackendCase.dtos.responses;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetTransactionByIdResponse {
    private int id;
    private BigDecimal amount;
    private String description;
    private String transaction_type;
    private LocalDate transaction_date;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String name;
}
