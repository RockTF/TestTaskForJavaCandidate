package com.example.TestTaskForJavaCandidate.repository.jpa.entity;

import jakarta.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "users")
public class UserMongo {

    @Id
    private final UUID id;
    private final String username;
    private final String name;
    private final String surname;

    public UserMongo(UUID id, String username, String name, String surname) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
    }

    public UUID getUserId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
