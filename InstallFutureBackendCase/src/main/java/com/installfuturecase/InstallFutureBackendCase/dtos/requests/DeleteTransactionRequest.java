package com.installfuturecase.InstallFutureBackendCase.dtos.requests;
import jakarta.validation.constraints.NotNull;
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
public class DeleteTransactionRequest {
    @NotNull
    private Integer id;
}
