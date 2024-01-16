package com.example.TestTaskForJavaCandidate.config.migration;

import com.example.TestTaskForJavaCandidate.config.RepositoryConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(RepositoryConfig.class)
class MigrationTestConfig {}