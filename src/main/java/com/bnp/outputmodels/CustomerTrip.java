package com.bnp.outputmodels;

import com.bnp.CustomerService;
import com.bnp.inputmodels.Tap;
import java.util.List;
import java.util.Map;
public class CustomerTrip {
    private Integer customerId;
    private Integer totalCostInCents;
    private List<Trip> trips;

    public CustomerTrip(Map.Entry<Integer, List<Tap>> entry) {
        customerId = entry.getKey();
        trips = CustomerService.prepareListOfTrips(entry);
        totalCostInCents = trips.stream()
                .map(Trip::getCostInCents)
                .reduce(0, Integer::sum);
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    public Integer getTotalCostInCents() {
        return totalCostInCents;
    }
    public void setTotalCostInCents(Integer totalCostInCents) {
        this.totalCostInCents = totalCostInCents;
    }
    public List<Trip> getTrips() {
        return trips;
    }
    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
