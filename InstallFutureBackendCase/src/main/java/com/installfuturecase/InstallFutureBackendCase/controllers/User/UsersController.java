package com.installfuturecase.InstallFutureBackendCase.controllers.User;

import java.util.List;

import com.installfuturecase.InstallFutureBackendCase.dtos.requests.CreateUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.DeleteUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.requests.UpdateUserRequest;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetAllUsersResponse;
import com.installfuturecase.InstallFutureBackendCase.dtos.responses.GetUserByIdResponse;

import jakarta.validation.Valid;

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


import com.installfuturecase.InstallFutureBackendCase.business.abstracts.IUsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
    private IUsersService usersService;

    @Autowired
    public UsersController(IUsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/getAll")
    public List<GetAllUsersResponse> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public GetUserByIdResponse getByIdProgrammingLanguagesResponse(@PathVariable int id) {
        return usersService.getUserById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateUserRequest request) {
        System.out.println("Name: " + request.getName());
        System.out.println("Email: " + request.getEmail());
        System.out.println("Password: " + request.getPassword());
        this.usersService.add(request);
    }

    @PutMapping("/update")
    public void update(@RequestBody UpdateUserRequest request) {
        this.usersService.update(request);
    }

    @DeleteMapping("/delete")
    public void  delete(DeleteUserRequest request) {
        this.usersService.delete(request);
    }
}
