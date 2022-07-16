package com.bridgelabz;

import java.util.HashMap;
import java.util.Map;

public class CabInvoiceGenerator {
    private static final int COST_PER_KM = 10;
    private static final int COST_PER_MIN = 1;
    private static final int MIN_FARE = 5;

    public double CalculateFare(double distance, int time) {

        double totalFare = distance * COST_PER_KM + time * COST_PER_MIN;

        if (totalFare < MIN_FARE) {

            return MIN_FARE;
        }
        return totalFare;
    }
    public double calculateFareForMultipleRides(Ride[] rides) {

        double totalFare = 0.0;

        for (Ride ride : rides) {
            totalFare = CalculateFare(ride.getDistance(), ride.getTime());
        }

        return totalFare;
    }
    public InvoiceSummary invoiceSummaryCalculation(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += CalculateFare(ride.getDistance(), ride.getTime());
        }
        return new InvoiceSummary(rides.length, totalFare);
    }
    public InvoiceSummary getInvoice(int userId) {

        Map<Integer, Ride[]> map = new HashMap<>();

        Ride[] rides1 = {new Ride(2.0, 5),
                new Ride(0.1, 1)
        };

        Ride[] rides2 = {new Ride(5.0, 10),
                new Ride(1, 1)
        };

        Ride[] rides3 = {new Ride(8.0, 15),
                new Ride(1, 10)
        };

        map.put(1, rides1);
        map.put(2, rides2);
        map.put(3, rides3);

        for (Map.Entry<Integer, Ride[]> entry : map.entrySet()) {
            if (userId == entry.getKey()) {
                System.out.println(entry.getKey());
                Ride[] ridesArray = entry.getValue();
                return invoiceSummaryCalculation(ridesArray);
            }
        }
        return null;
    }
}

