package com.installfuturecase.InstallFutureBackendCase.dtos.responses;

import java.time.LocalDateTime;
import com.installfuturecase.InstallFutureBackendCase.entities.Transaction;
import java.util.List;
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
public class GetAllUsersResponse {
    private int id;
    private String name;
    private String email;
    private String role;
    private LocalDateTime created_at;
    private List<Transaction> transactions;
}
