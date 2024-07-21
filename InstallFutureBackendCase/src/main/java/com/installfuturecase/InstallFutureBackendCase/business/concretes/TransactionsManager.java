package com.installfuturecase.InstallFutureBackendCase.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.installfuturecase.InstallFutureBackendCase.business.abstracts.ITransactionsService;
import com.installfuturecase.InstallFutureBackendCase.business.core.utilities.IModelMapperService;
import com.installfuturecase.InstallFutureBackendCase.dataAcces.abstracts.ITransactionsRepository;
import com.installfuturecase.InstallFutureBackendCase.dataAcces.abstracts.IUsersRepository;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.CreateTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.DeleteTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.UpdateTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllTransactionsResponse;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetTransactionByIdResponse;
import com.installfuturecase.InstallFutureBackendCase.entities.Transaction;
import com.installfuturecase.InstallFutureBackendCase.entities.User;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TransactionsManager implements ITransactionsService{

    private ITransactionsRepository transactionsRepository;
    private IModelMapperService modelMapperService;
    private IUsersRepository usersRepository;
    
    @Override
    @Transactional
    public List<GetAllTransactionsResponse> getAllTransactions() {
        List<Transaction> transactions ;
        List<GetAllTransactionsResponse> response = new ArrayList<>();
        
        try {
            transactions = transactionsRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching users", e);
        }
        
        response = transactions.stream()
            .map(transaction -> modelMapperService.forResponse().map(transaction, GetAllTransactionsResponse.class))
            .toList();
        
        return response;
    }

    @Override
    @Transactional
    public GetTransactionByIdResponse getTransactionById(int id) {

        Transaction transaction = transactionsRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Transaction not found with id: " + id));

        GetTransactionByIdResponse response = modelMapperService.forResponse().map(transaction, GetTransactionByIdResponse.class);

        return response;
    }

    @Override
    @Transactional 
    public void add(CreateTransactionRequest request) {
        Transaction transaction = this.modelMapperService.forRequest().map(request, Transaction.class);
        User user = usersRepository.findById(request.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        transaction.setUser(user);
        transactionsRepository.save(transaction);
    }

    @Override
    @Transactional
    public void update(UpdateTransactionRequest request) {
        Transaction transaction = this.transactionsRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));

        this.modelMapperService.forRequest().map(request, transaction);

        this.transactionsRepository.save(transaction);
    }

    @Override
    @Transactional
    public void delete(DeleteTransactionRequest request) {
        Transaction transaction = this.transactionsRepository.findById(request.getId())
                .orElseThrow(() -> new EntityNotFoundException("Transaction not found"));

        transactionsRepository.delete(transaction);
    }
    
}