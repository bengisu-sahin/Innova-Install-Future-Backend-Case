package com.installfuturecase.InstallFutureBackendCase.controllers.Transaction;
import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.installfuturecase.InstallFutureBackendCase.business.abstracts.ITransactionsService;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.CreateTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.DeleteTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.UpdateTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllTransactionsResponse;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetTransactionByIdResponse;


@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private ITransactionsService transactionsService;

    @Autowired 
    public TransactionController(ITransactionsService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @GetMapping("/getAll")
    public List<GetAllTransactionsResponse> getAllUsers() {
        return this.transactionsService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public GetTransactionByIdResponse getByIdProgrammingLanguagesResponse(@PathVariable int id) {
        return this.transactionsService.getTransactionById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@Valid @RequestBody CreateTransactionRequest request) {
        this.transactionsService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateTransactionRequest request) {
        this.transactionsService.update(request);
    }

    @DeleteMapping("/delete")
    public void  delete(DeleteTransactionRequest request) {
        this.transactionsService.delete(request);
    }
}