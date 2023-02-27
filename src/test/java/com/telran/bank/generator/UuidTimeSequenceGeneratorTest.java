package com.telran.bank.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UuidTimeSequenceGeneratorTest {

    private static final String UUID_PATTERN = "^[\\da-fA-F]{8}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{4}-[\\da-fA-F]{12}$";

    @Mock
    private JdbcTemplate jdbcTemplate;

    @InjectMocks
    private UuidTimeSequenceGenerator generator;


    @DisplayName("Must generate valid UUID value")
    @Test
    void generateOneUuidValue() {

        when(jdbcTemplate.queryForObject(anyString(), (RowMapper<Object>) any()))
                .thenReturn((long) (Math.random() * 1000000));

        UUID actualUuid = (UUID) generator.generate(null, null);

        assertTrue(actualUuid.toString().matches(UUID_PATTERN));
    }
}
