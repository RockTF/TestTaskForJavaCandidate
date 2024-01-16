package com.example.TestTaskForJavaCandidate.api.mapper;

import org.junit.jupiter.api.Test;
import com.example.TestTaskForJavaCandidate.api.ressponse.UserResponse;
import com.example.TestTaskForJavaCandidate.application.model.User;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserResponseMapperTest {

    @Test
    public void shouldMapUserToUserResponse() {
        // given
        User user = new User(UUID.randomUUID(), "johndoe", "John", "Doe");

        // when
        UserResponse response = UserResponseMapper.toResponse(user);

        // then
        assertNotNull(response);
        assertEquals(user.userId(), response.userId());
        assertEquals(user.username(), response.username());
        assertEquals(user.name(), response.name());
        assertEquals(user.surname(), response.surname());
    }
}