package com.example.TestTaskForJavaCandidate.application.port;

import com.example.TestTaskForJavaCandidate.application.model.User;

import java.util.List;

public interface IActionUserRepository {
    List<User> getAllUsers();
}
