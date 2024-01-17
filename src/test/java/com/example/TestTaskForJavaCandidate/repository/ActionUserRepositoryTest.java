package com.example.TestTaskForJavaCandidate.repository;

import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.repository.jpa.IActionUserMongoRepository;
import com.example.TestTaskForJavaCandidate.repository.jpa.IActionUserPostgresRepository;
import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserEntity;
import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserMongo;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActionUserRepositoryTest {

    @Mock
    private IActionUserPostgresRepository actionUserJpaRepository;

    @Mock
    private IActionUserMongoRepository actionUserMongoRepository;

    @InjectMocks
    private ActionUserRepository actionUserRepository;

    @Test
    public void testGetAllUsers() {
        // given
        UserEntity postgresUser = new UserEntity(UUID.randomUUID(), "johndoe1", "John1", "Doe1");
        UserMongo mongoUser = new UserMongo(new ObjectId(), "johndoe2", "John2", "Doe2");

        when(actionUserJpaRepository.findAll()).thenReturn(List.of(postgresUser));
        when(actionUserMongoRepository.findAll()).thenReturn(List.of(mongoUser));

        // when
        List<User> result = actionUserRepository.getAllUsers();

        // then
        assertEquals(2, result.size());

        verify(actionUserJpaRepository).findAll();
        verify(actionUserMongoRepository).findAll();
        verifyNoMoreInteractions(actionUserJpaRepository);
    }

    @Test
    public void getAllUsers_ShouldThrowException() {
        // given
        RuntimeException exception = new RuntimeException("Database error");
        when(actionUserJpaRepository.findAll()).thenThrow(exception);

        // when
        assertThrows(RuntimeException.class, () -> actionUserRepository.getAllUsers());

        // then
        verify(actionUserJpaRepository).findAll();
    }
}