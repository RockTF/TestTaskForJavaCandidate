package com.example.TestTaskForJavaCandidate.repository.jpa;

import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface IActionUserMongoRepository extends MongoRepository<UserMongo, UUID> {}
