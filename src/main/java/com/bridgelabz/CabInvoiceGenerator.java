package com.bridgelabz;

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
}

