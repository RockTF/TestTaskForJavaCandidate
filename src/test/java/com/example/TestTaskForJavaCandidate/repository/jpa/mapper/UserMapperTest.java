package com.example.TestTaskForJavaCandidate.repository.jpa.mapper;

import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserEntity;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;


public class UserMapperTest {

    @Test
    public void toModel_ShouldCorrectlyMapUserEntityToUser() {
        // given
        UserEntity jpaEntity = new UserEntity(UUID.randomUUID(), "johndoe", "John", "Doe");

        // when
        User user = UserMapper.toModel(jpaEntity);

        // then
        assertNotNull(user);
        assertEquals(jpaEntity.getUserId(), user.userId());
        assertEquals(jpaEntity.getUsername(), user.username());
        assertEquals(jpaEntity.getName(), user.name());
        assertEquals(jpaEntity.getSurname(), user.surname());
    }
}