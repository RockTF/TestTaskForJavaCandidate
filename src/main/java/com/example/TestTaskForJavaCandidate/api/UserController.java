package com.example.TestTaskForJavaCandidate.api;

import com.example.TestTaskForJavaCandidate.api.mapper.UserResponseMapper;
import com.example.TestTaskForJavaCandidate.api.ressponse.UserResponse;
import com.example.TestTaskForJavaCandidate.application.usecase.IGetUserUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IGetUserUseCase getUserUseCase;

    public UserController(IGetUserUseCase getUserUseCase) {
        this.getUserUseCase = getUserUseCase;
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return getUserUseCase.findAllUsers().stream().map(UserResponseMapper::toResponse).toList();
    }
}
