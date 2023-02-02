package com.bnp.outputmodels;

import com.bnp.CustomerService;
import com.bnp.config.InputFileMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerSummaries {
    private List<CustomerTrip> customerSummaries;

    public CustomerSummaries(InputFileMapper reader, File inputFile) throws IOException {
        System.out.println("File Input processing...");
        customerSummaries = CustomerService.getCustomersById(reader.parse(inputFile))
                .entrySet()
                .parallelStream()
                .map(CustomerTrip::new)
                .sorted(Comparator.comparingInt(CustomerTrip::getCustomerId))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public List<CustomerTrip> getCustomerSummaries() {
        return customerSummaries;
    }

    public void setCustomerSummaries(List<CustomerTrip> customerSummaries) {
        this.customerSummaries = customerSummaries;
    }
}
