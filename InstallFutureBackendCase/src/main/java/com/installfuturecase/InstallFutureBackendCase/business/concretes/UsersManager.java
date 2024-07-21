package com.installfuturecase.InstallFutureBackendCase.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.installfuturecase.InstallFutureBackendCase.business.abstracts.IUsersService;
import com.installfuturecase.InstallFutureBackendCase.business.core.utilities.IModelMapperService;
import com.installfuturecase.InstallFutureBackendCase.dataAcces.abstracts.IUsersRepository;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.CreateUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.DeleteUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.UpdateUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllUsersResponse;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetUserByIdResponse;
import com.installfuturecase.InstallFutureBackendCase.entities.User;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
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

    @Override
    @Transactional
    public GetUserByIdResponse getUserById(int id) {
        User user = usersRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        GetUserByIdResponse response = modelMapperService.forResponse().map(user, GetUserByIdResponse.class);

        return response;
    }

    @Override
    @Transactional
    public void add(CreateUserRequest createUserRequest) {
        if (usersRepository.existsByEmail(createUserRequest.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = modelMapperService.forRequest().map(createUserRequest, User.class);

        try {
            usersRepository.save(user);
            System.out.println("Saved User ID: " + user.getId()); 
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while adding user", e);
        }
    }

    @Override
    @Transactional
    public void update(UpdateUserRequest updateUserRequest) {
        User user = this.usersRepository.findById(updateUserRequest.getId())
                .orElseThrow(() -> new EntityNotFoundException("ProgrammingLanguage not found"));

        this.modelMapperService.forRequest().map(updateUserRequest, user);

        this.usersRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(DeleteUserRequest deleteUserRequest) {
        User user = usersRepository.findByIdAndEmail(deleteUserRequest.getId(), deleteUserRequest.getEmail())
        .orElseThrow(() -> new EntityNotFoundException("User not found"));

        usersRepository.delete(user);
    }
    
}
