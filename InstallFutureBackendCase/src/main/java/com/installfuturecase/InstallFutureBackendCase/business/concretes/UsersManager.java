package com.installfuturecase.InstallFutureBackendCase.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.installfuturecase.InstallFutureBackendCase.business.abstracts.IUsersService;
import com.installfuturecase.InstallFutureBackendCase.business.core.utilities.IModelMapperService;
import com.installfuturecase.InstallFutureBackendCase.dataAcces.abstracts.IUsersRepository;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllUsersResponse;
import com.installfuturecase.InstallFutureBackendCase.entities.User;

@Service
public class UsersManager implements IUsersService{

    private IUsersRepository usersRepository;
    private IModelMapperService modelMapperService;

    @Override
    public List<GetAllUsersResponse> getAllUsers() {
        List<User> users ;
        List<GetAllUsersResponse> response = new ArrayList<>();
        
        try {
            users = usersRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching users", e);
        }
        
        response = users.stream()
            .map(user -> modelMapperService.forResponse().map(user, GetAllUsersResponse.class))
            .toList();
        
        return response;
    
    }
    
}
