package com.bnp;

import com.bnp.config.OutputFileWriter;
import com.bnp.inputmodels.CustomerTaps;
import com.bnp.inputmodels.Tap;
import com.bnp.outputmodels.CustomerSummaries;
import com.bnp.outputmodels.Trip;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.groupingBy;

public class CustomerService {

    public static Map<Integer, List<Tap>> getCustomersById(CustomerTaps taps) {
        return taps.getTaps().stream()
                .collect(groupingBy(Tap::getCustomerId));
    }

    public static List<Trip> prepareListOfTrips(Map.Entry<Integer, List<Tap>> entry) {
        final List<Tap> tapsByCustomer = entry.getValue();
        tapsByCustomer.sort(comparing(Tap::getUnixTimestamp));
        return IntStream.range(0, tapsByCustomer.size() / 2)
                .mapToObj(index -> {
                    Tap startTap = tapsByCustomer.get(2 * index);
                    Tap endTap = tapsByCustomer.get(2 * index + 1);
                    Trip trip = startTap.getStation().FromStartZoneToDestinationZone(endTap.getStation())
                            .orElseThrow(IllegalArgumentException::new);
                    trip.setStartedJourneyAt(startTap.getUnixTimestamp());
                    return trip;
                })
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public static void writeOutputFile(OutputFileWriter writer, File outputFile, CustomerSummaries customerSummaries) throws IOException {
        writer.processWrite(outputFile, customerSummaries);
    }

}
