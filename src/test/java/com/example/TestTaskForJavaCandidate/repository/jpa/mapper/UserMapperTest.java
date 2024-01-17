package com.example.TestTaskForJavaCandidate.repository.jpa.mapper;

import com.example.TestTaskForJavaCandidate.application.model.User;
import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserEntity;
import com.example.TestTaskForJavaCandidate.repository.jpa.entity.UserMongo;
import org.bson.types.ObjectId;
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

    @Test
    public void testToModelFromUserMongo() {
        // given
        UserMongo document = new UserMongo(
                new ObjectId(),
                "user456",
                "Alice",
                "Johnson"
        );

        byte[] objectIdBytes = document.getUserId().toByteArray();

        UUID uuid = UUID.nameUUIDFromBytes(objectIdBytes);

        // when
        User user = UserMapper.toModel(document);

        // then
        assertEquals(uuid, user.userId());
        assertEquals(document.getUsername(), user.username());
        assertEquals(document.getName(), user.name());
        assertEquals(document.getSurname(), user.surname());
    }
}