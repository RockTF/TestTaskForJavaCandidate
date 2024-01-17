package com.example.TestTaskForJavaCandidate.repository.jpa;

import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IActionUserMongoRepository extends MongoRepository<UserMongo, ObjectId> {}
