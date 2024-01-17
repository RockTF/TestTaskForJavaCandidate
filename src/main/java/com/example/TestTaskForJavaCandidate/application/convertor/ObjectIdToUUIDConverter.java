package com.example.TestTaskForJavaCandidate.application.convertor;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.bson.types.ObjectId;

import java.nio.ByteBuffer;
import java.util.UUID;

@Configuration
@ReadingConverter
public class ObjectIdToUUIDConverter implements Converter<ObjectId, UUID> {

    @Override
    public UUID convert(ObjectId objectId) {
        byte[] bytes = objectId.toByteArray();

        if (bytes.length != 12) {
            throw new IllegalArgumentException("Invalid ObjectId length");
        }

        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        long mostSigBits = buffer.getLong();
        long leastSigBits = buffer.getLong();

        return new UUID(mostSigBits, leastSigBits);
    }
}
