package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Flight> testFlight = testsFlight.createFlights();

        FilterArrivalBeforeDeparture filterArrivalBeforeDeparture = new FilterArrivalBeforeDeparture();
        List<Flight> flightsSortedFilterArrivalBeforeDeparture = filterArrivalBeforeDeparture.filterFlights(testFlight);

        FilterFlightsToCurrentTime filterFlightsToCurrentTime = new FilterFlightsToCurrentTime();
        List<Flight> finalFlight = filterFlightsToCurrentTime.filterFlights(testFlight);


        TimeBetweenFlightsMoreTwoHours timeBetweenFlightsMoreTwoHours = new TimeBetweenFlightsMoreTwoHours();
        List<Flight> flightsSortedByTimeBetweenFlightsMoreTwoHours = timeBetweenFlightsMoreTwoHours.filterFlights(testFlight);





    }
}