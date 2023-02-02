package com.bnp.config;

import com.bnp.outputmodels.CustomerSummaries;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.File;
import java.io.IOException;

import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
class OutputFileWriterTest {
    @Mock
    private File outputFile;
    @Mock
    private CustomerSummaries summaries;
    @Mock
    private ObjectMapper mapper;
    @InjectMocks
    private OutputFileWriter writer;
    @Test
    void shouldWriteFileData() throws IOException {
        //Given
        willDoNothing().given(mapper).writeValue(outputFile, summaries);

        // When
        writer.processWrite(outputFile, summaries);

        // Then
        verify(mapper).writeValue(outputFile, summaries);
    }
}