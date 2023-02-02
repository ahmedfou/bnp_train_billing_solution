package com.bnp;

import com.bnp.config.InputFileMapper;
import com.bnp.config.ObjectMapperConfig;
import com.bnp.config.OutputFileWriter;
import com.bnp.outputmodels.CustomerSummaries;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Process {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            throw new Exception("Missing program args");
        } else {
            System.out.println("Start processing...");
            final File condidateInputFile = new File(args[0]);
            final File condidateOutputFile = new File(args[1]);
            final ObjectMapper mapper = new ObjectMapperConfig().getInstance();
            final InputFileMapper reader = new InputFileMapper(mapper);
            final OutputFileWriter writer = new OutputFileWriter(mapper);
            try {
                final CustomerSummaries customerSummaries = new CustomerSummaries(reader, condidateInputFile);
                System.out.println("Finish  Input File processing");
                System.out.println("Output file generating...");
                CustomerService.writeOutputFile(writer, condidateOutputFile, customerSummaries);
                System.out.println("Output file generated with success");
            } catch (IOException e) {
                System.err.println("Something is wrong " + e.getMessage());
                throw new Exception("Something is wrong");
            }
        }
    }
}