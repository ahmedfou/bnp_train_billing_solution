package com.bnp.config;

import com.bnp.outputmodels.CustomerSummaries;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
public class OutputFileWriter {
    private final ObjectMapper objectMapper;

    public OutputFileWriter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public void processWrite(File outputFile, CustomerSummaries customerSummaries) throws IOException {
        objectMapper.writeValue(outputFile, customerSummaries);
    }
}
