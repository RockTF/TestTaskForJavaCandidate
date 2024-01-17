package com.example.TestTaskForJavaCandidate.repository.jpa.mapper;

import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserEntity;
import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserMongo;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public static User toModel(UserEntity jpaEntity) {

        return  new User(
                jpaEntity.getUserId(),
                jpaEntity.getUsername(),
                jpaEntity.getName(),
                jpaEntity.getSurname()
        );
    }

    public static User toModel(UserMongo document) {

        return  new User(
                document.getUserId(),
                document.getUsername(),
                document.getName(),
                document.getSurname()
        );
    }
}
