package com.example.TestTaskForJavaCandidate.application.usecase;

import com.example.TestTaskForJavaCandidate.application.model.User;

import java.util.List;

public interface IGetUserUseCase {

    List<User> findAllUsers();
}
