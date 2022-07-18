package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        CabInvoiceGenerator invoiceService = new  CabInvoiceGenerator();
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare,0);
    }

    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        CabInvoiceGenerator invoiceService = new  CabInvoiceGenerator();
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5.0, totalFare,0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnTotalOfTotalFare() {
        CabInvoiceGenerator invoiceService = new  CabInvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(5.0, 10),
                new Ride(0.1, 1),
                new Ride(20, 60)
        };

        double Fare = invoiceService.calculateFareForMultipleRides(rides);

        Assert.assertEquals(350, Fare, 0);
    }
    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        CabInvoiceGenerator invoiceService = new CabInvoiceGenerator();
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };

        InvoiceSummary invoiceSummary = invoiceService.invoiceSummaryCalculation(rides);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }
    @Test
    public void givenUserId_ShouldReturnInvoiceSummary() {
        CabInvoiceGenerator invoiceService = new CabInvoiceGenerator();
        InvoiceSummary invoiceSummary = invoiceService.getInvoice(3);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 115);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

   @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnInvoiceSummary() {
        String type = "Normal";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary invoiceSummary =  CabInvoiceGenerator.calculateTotalFare(rides, type);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }

    @Test
    public void givenMultipleRides_WhenPremium_ShouldReturnInvoiceSummary() {
        String type = "Premium";
        Ride[] rides = {new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary invoiceSummary =  CabInvoiceGenerator.calculateTotalFare(rides, type);
        InvoiceSummary expectedInvoices = new InvoiceSummary(2, 60.0);
        Assert.assertEquals(expectedInvoices.getInvoiceSummary(), invoiceSummary.getInvoiceSummary());
    }
}
