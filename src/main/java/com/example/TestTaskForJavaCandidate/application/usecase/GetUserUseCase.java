package com.example.TestTaskForJavaCandidate.application.usecase;

import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.application.port.IActionUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserUseCase implements IGetUserUseCase{

    private final IActionUserRepository actionUserRepository;

    public GetUserUseCase(IActionUserRepository actionUserRepository) {
        this.actionUserRepository = actionUserRepository;
    }

    @Override
    public List<User> findAllUsers() {
        return actionUserRepository.getAllUsers();
    }
}
