package com.installfuturecase.InstallFutureBackendCase.config;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.installfuturecase.InstallFutureBackendCase.dtos.requests.CreateTransactionRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.CreateUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllTransactionsResponse;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllUsersResponse;
import com.installfuturecase.InstallFutureBackendCase.entities.Transaction;
import com.installfuturecase.InstallFutureBackendCase.entities.User;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.typeMap(CreateUserRequest.class, User.class).addMappings(mapper -> {
            mapper.map(CreateUserRequest::getName, User::setName);
            mapper.map(CreateUserRequest::getEmail, User::setEmail);
            mapper.map(CreateUserRequest::getPassword, User::setPassword);
            mapper.skip(User::setId);
        });

        modelMapper.typeMap(CreateTransactionRequest.class, Transaction.class).addMappings(mapper -> {
            mapper.skip(Transaction::setId);
        });
        // modelMapper.addMappings(new PropertyMap<User, GetAllUsersResponse>() {
        //     @Override
        //     protected void configure() {
        //         map().setCreated_at(source.getCreated_at());
        //         map().setUpdated_at(source.getUpdated_at());
                
        //     }
        // });
        return modelMapper;
    }
}