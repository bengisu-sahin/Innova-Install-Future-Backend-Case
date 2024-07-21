package com.installfuturecase.InstallFutureBackendCase.business.abstracts;

import java.util.List;

import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllUsersResponse;

public interface IUsersService {
    public List<GetAllUsersResponse> getAllUsers();
}
