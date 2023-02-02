package com.bnp.config;

import com.bnp.inputmodels.CustomerTaps;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class InputFileMapper {
    private final ObjectMapper objectMapper;
    public InputFileMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    public CustomerTaps parse(File inputFile) throws IOException {
        return objectMapper.readValue(inputFile, CustomerTaps.class);
    }
}
