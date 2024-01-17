package com.example.TestTaskForJavaCandidate.repository.jpa.entity;

import jakarta.persistence.Id;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class UserMongo {

    @Id
    private final ObjectId id;
    private final String username;
    private final String name;
    private final String surname;

    public UserMongo(ObjectId id, String username, String name, String surname) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.surname = surname;
    }

    public ObjectId getUserId() {
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
