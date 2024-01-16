package com.example.TestTaskForJavaCandidate.api.mapper;

import com.example.TestTaskForJavaCandidate.api.ressponse.UserResponse;
import com.example.TestTaskForJavaCandidate.application.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserResponseMapper {

    public static UserResponse toResponse(User model) {

        return  new UserResponse(
                model.userId(),
                model.username(),
                model.name(),
                model.surname()
        );
    }
}
