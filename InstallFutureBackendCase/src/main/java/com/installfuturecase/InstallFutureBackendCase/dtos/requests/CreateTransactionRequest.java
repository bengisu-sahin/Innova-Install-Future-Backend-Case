package com.installfuturecase.InstallFutureBackendCase.dtos.requests;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class CreateTransactionRequest {
    @NotNull
    private BigDecimal amount;

    @Size(max = 255)
    private String description;

    @Size(max = 50)
    private String transaction_type; 

    @NotNull
    private LocalDate transaction_date;

    @NotNull
    private int user_id;

}
