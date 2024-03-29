package com.example.TestTaskForJavaCandidate.repository.jpa;

import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IActionUserPostgresRepository extends JpaRepository<UserEntity, UUID>{}
