package com.example.TestTaskForJavaCandidate.application.usecase;

import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.application.port.IActionUserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GetUserUseCaseTest {

    @Mock
    private IActionUserRepository actionUserRepository;

    @InjectMocks
    private GetUserUseCase getUserUseCase;

    @Test
    public void findAllUsers_ShouldReturnListOfUsers() {
        // given
        User user1 = new User(UUID.randomUUID(), "johndoe1", "John1", "Doe1");
        User user2 = new User(UUID.randomUUID(), "johndoe2", "John2", "Doe2");
        when(actionUserRepository.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        // when
        List<User> result = getUserUseCase.findAllUsers();

        // then
        assertEquals(2, result.size());
        assertEquals(user1, result.get(0));
        assertEquals(user2, result.get(1));
    }
}