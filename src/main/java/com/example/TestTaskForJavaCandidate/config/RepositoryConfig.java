package com.example.TestTaskForJavaCandidate.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.TestTaskForJavaCandidate.repository.jpa")
@EnableJpaRepositories(basePackages = "com.example.TestTaskForJavaCandidate.repository.jpa")
public class RepositoryConfig {}
