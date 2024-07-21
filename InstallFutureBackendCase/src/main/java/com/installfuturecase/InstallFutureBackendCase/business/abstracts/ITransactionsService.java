package com.installfuturecase.InstallFutureBackendCase.business.abstracts;

import java.util.List;

import com.installfuturecase.InstallFutureBackendCase.dtos.requests.CreateTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.DeleteTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.UpdateTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllTransactionsResponse;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetTransactionByIdResponse;

public interface ITransactionsService {
    public List<GetAllTransactionsResponse> getAllTransactions();
    public GetTransactionByIdResponse getTransactionById(int id);
    public void add(CreateTransactionRequest request);
    public void update(UpdateTransactionRequest request);
    public void delete(DeleteTransactionRequest request);
}
