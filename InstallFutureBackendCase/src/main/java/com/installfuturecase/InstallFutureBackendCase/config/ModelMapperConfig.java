package com.installfuturecase.InstallFutureBackendCase.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.installfuturecase.InstallFutureBackendCase.dtos.requests.CreateUserRequest;
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
        return modelMapper;
    }
}