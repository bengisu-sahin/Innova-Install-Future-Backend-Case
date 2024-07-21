package com.installfuturecase.InstallFutureBackendCase.business.abstracts;

import java.util.List;

import com.installfuturecase.InstallFutureBackendCase.dtos.requests.CreateUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.DeleteUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.UpdateUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllUsersResponse;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetUserByIdResponse;

public interface IUsersService {
    public List<GetAllUsersResponse> getAllUsers();
    public GetUserByIdResponse getUserById(int id);
    public void add(CreateUserRequest createUserRequest);
    public void update(UpdateUserRequest updateUserRequest);
    public void delete(DeleteUserRequest deleteUserRequest);
}
