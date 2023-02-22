package com.telran.bank.mapper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test class for UuidMapper")
class UuidMapperTest {

    private final UuidMapper mapper = new UuidMapperImpl();

    @DisplayName("Test converting from UUID to String")
    @Test
    void testToString() {
        String uuidString = "01234567-8901-abcd-abcd-1234567890ab";
        UUID uuid = UUID.fromString(uuidString);

        String actualUuidSting = mapper.toString(uuid);

        assertEquals(uuidString, actualUuidSting);
    }

    @DisplayName("Test converting String to UUID")
    @Test
    void toUUID() {
        String uuidString = "01234567-8901-abcd-abcd-1234567890ab";
        UUID uuid = UUID.fromString(uuidString);

        UUID actualUuid = mapper.fromString(uuidString);

        assertEquals(uuid, actualUuid);
    }
}