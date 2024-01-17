package com.example.TestTaskForJavaCandidate.repository;

import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.application.port.IActionUserRepository;
import com.example.TestTaskForJavaCandidate.repository.jpa.IActionUserMongoRepository;
import com.example.TestTaskForJavaCandidate.repository.jpa.IActionUserPostgresRepository;
import com.example.TestTaskForJavaCandidate.repository.jpa.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional()
public class ActionUserRepository implements IActionUserRepository {

    private final IActionUserPostgresRepository actionUserJpaRepository;

    private final IActionUserMongoRepository actionUserMongoRepository;

    private static final Logger log = LoggerFactory.getLogger(ActionUserRepository.class);

    public ActionUserRepository(IActionUserPostgresRepository actionUserJpaRepository, IActionUserMongoRepository actionUserMongoRepository) {
        this.actionUserJpaRepository = actionUserJpaRepository;
        this.actionUserMongoRepository = actionUserMongoRepository;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            Stream<User> jpaUsersStream = actionUserJpaRepository.findAll().stream()
                    .map(UserMapper::toModel);

            Stream<User> mongoUsersStream = actionUserMongoRepository.findAll().stream()
                    .map(UserMapper::toModel);

            List<User> users = Stream.concat(jpaUsersStream, mongoUsersStream)
                    .collect(Collectors.toList());

            log.info("Successfully got all users");
            return users;
        } catch (Exception e) {
            log.error("Could not get users", e);
            throw e;
        }
    }
}
