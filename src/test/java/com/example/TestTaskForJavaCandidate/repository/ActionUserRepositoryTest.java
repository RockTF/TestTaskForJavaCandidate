package com.example.TestTaskForJavaCandidate.repository;

import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.repository.jpa.IActionUserJpaRepository;
import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ActionUserRepositoryTest {

    @Mock
    private IActionUserJpaRepository actionUserJpaRepository;

    @InjectMocks
    private ActionUserRepository actionUserRepository;

    @Test
    public void getAllUsers_ShouldReturnListOfUsers() {
        // given
        UserEntity userEntity1 = new UserEntity(UUID.randomUUID(), "johndoe1", "John1", "Doe1"); // Assuming default constructor and setters
        UserEntity userEntity2 = new UserEntity(UUID.randomUUID(), "johndoe2", "John2", "Doe2"); // Setup userEntity1 and userEntity2 with test data
        when(actionUserJpaRepository.findAll()).thenReturn(Arrays.asList(userEntity1, userEntity2));

        // when
        List<User> result = actionUserRepository.getAllUsers();

        // then
        assertNotNull(result);
        assertEquals(2, result.size());

        // Additional assertions can be added to verify the mapping
        verify(actionUserJpaRepository).findAll();
        verifyNoMoreInteractions(actionUserJpaRepository);
    }
}