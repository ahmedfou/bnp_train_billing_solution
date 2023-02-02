package com.bnp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
public class ObjectMapperConfig {
    private final ObjectMapper objectMapper;
    public ObjectMapperConfig() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public ObjectMapper getInstance() {
        return objectMapper;
    }

}
