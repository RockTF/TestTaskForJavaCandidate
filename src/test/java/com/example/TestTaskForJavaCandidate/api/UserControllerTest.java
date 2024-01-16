package com.example.TestTaskForJavaCandidate.api;

import com.example.TestTaskForJavaCandidate.api.ressponse.UserResponse;
import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.application.usecase.IGetUserUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private IGetUserUseCase getUserUseCase;

    @InjectMocks
    private UserController userController;

    @Test
    public void getAllUsers_ShouldReturnListOfUserResponses() {
        // given
        User user1 = new User(UUID.randomUUID(), "johndoe1", "John1", "Doe1");
        User user2 = new User(UUID.randomUUID(), "janedoe2", "Jane2", "Doe2");

        when(getUserUseCase.findAllUsers()).thenReturn(Arrays.asList(user1, user2));

        // when
        List<UserResponse> result = userController.getAllUsers();

        // then
        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(user1.userId(), result.get(0).userId());
        assertEquals(user2.userId(), result.get(1).userId());

        // verify
        verify(getUserUseCase, times(1)).findAllUsers();
    }
}