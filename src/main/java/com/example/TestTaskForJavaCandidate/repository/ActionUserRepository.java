package com.example.TestTaskForJavaCandidate.repository;

import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.application.port.IActionUserRepository;
import com.example.TestTaskForJavaCandidate.repository.jpa.IActionUserJpaRepository;
import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserEntity;
import com.example.TestTaskForJavaCandidate.repository.jpa.mapper.UserMapper;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional()
public class ActionUserRepository implements IActionUserRepository {

    private final IActionUserJpaRepository actionUserJpaRepository;

    private static final Logger log = LoggerFactory.getLogger(ActionUserRepository.class);

    public ActionUserRepository(IActionUserJpaRepository actionUserJpaRepository) {
        this.actionUserJpaRepository = actionUserJpaRepository;
    }

    @Override
    public List<User> getAllUsers() {
        try {
            List<UserEntity> entity = actionUserJpaRepository.findAll();
            log.info("Successfully got all users");
            return entity.stream().map(UserMapper::toModel).toList();
        } catch (Exception e) {
            log.error("Could not get users", e);
            throw e;
        }
    }
}
