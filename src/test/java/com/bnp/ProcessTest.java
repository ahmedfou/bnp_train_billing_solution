package com.bnp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldThrowExceptionWhenRunMain() {
        // Given
        System.out.println("main");
        String[] args = new String[0];
        boolean isException = false;
        // When
        try {
            Process.main(args);
        } catch (Exception e) {
            isException = true;
        }
        // Then
        assertTrue(isException);
    }

    @Test
    void shouldRunMain() {
        // Given
        System.out.println("main");
        String[] args = new String[2];
        args[0] = "src/test/resources/candidateinputTest.json";
        args[1] = "src/test/resources/candidateoutputTest.json";

        boolean isException = false;
        // When
        try {
            Process.main(args);
        } catch (Exception e) {
            isException = true;
        }
        // Then
        assertFalse(isException);
    }

    @Test
    void shouldThrowExceptionWhenWrongPath() {
        // Given
        System.out.println("main");
        String[] args = new String[2];
        args[0] = "src/test/resources/candidateinputTestWrongPath.json";
        args[1] = "src/test/resources/candidateoutputTest.json";

        boolean isException = false;
        // When
        try {
            Process.main(args);
        } catch (Exception e) {
            isException = true;
        }
        // Then
        assertTrue(isException);
    }

    @Test
    void shouldThrowExceptionWhenWrongArgs() {
        // Given
        System.out.println("main");
        String[] args = new String[2];
        args[0] = "src/test/resources/candidateinputTest.json";

        boolean isException = false;
        // When
        try {
            Process.main(args);
        } catch (Exception e) {
            isException = true;
        }
        // Then
        assertTrue(isException);
    }
}