package com.example.TestTaskForJavaCandidate.application.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.UUID;

@Data
@EqualsAndHashCode(callSuper = true)
public record User(UUID userId, String username, String name, String surname) {}