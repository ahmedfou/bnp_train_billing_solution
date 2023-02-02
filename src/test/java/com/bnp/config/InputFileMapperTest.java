package com.bnp.config;

import com.bnp.inputmodels.CustomerTaps;
import com.bnp.inputmodels.Tap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class InputFileMapperTest {

    private ObjectMapper mapper;
    private InputFileMapper inputFileMapper;

    @BeforeEach
    void setUp() {
        mapper = new ObjectMapperConfig().getInstance();
        inputFileMapper = new InputFileMapper(mapper);
    }

    @Test
    void shouldParseTheInputFile() throws IOException {
        // Given
        File inputFileTest = Paths.get("src/test/resources/candidateinputTest.json").toFile();

        // When
        CustomerTaps result = inputFileMapper.parse(inputFileTest);

        // Then
        assertThat(result).isNotNull();
        System.out.println(result);
        List<Tap> taps = result.getTaps();
        assertThat(taps).isNotEmpty();
        assertThat(taps).hasSize(16);
    }

    @Test
    void shouldThrowExceptionWhenWrongPath() {
        // Given
        boolean isException = false;
        File inputFileTest = Paths.get("src/test/resources/candidateinputTest2.json").toFile();

        // When&Then
        try {
            inputFileMapper.parse(inputFileTest);
        } catch (IOException e) {
            isException = true;
        }
        assertThat(isException).isTrue();
    }
}