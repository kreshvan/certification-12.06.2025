package com.gridnine.testing;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterArrivalBeforeDepartureTest {


    @Test
    void filterFlights() {

        LocalDateTime departureTestTrue = LocalDateTime.parse("2025-06-05T20:00");
        LocalDateTime arrivalTestTrue = LocalDateTime.parse("2025-06-05T22:00");

        List<Segment> segmentsTestTrue = new ArrayList<>();
        Segment segment = new Segment(departureTestTrue, arrivalTestTrue);
        segmentsTestTrue.add(segment);
        Flight flightTestTrue = new Flight(segmentsTestTrue);

        LocalDateTime departureTestFalse = LocalDateTime.parse("2025-06-05T22:00");
        LocalDateTime arrivalTestFalse = LocalDateTime.parse("2025-06-05T20:00");

        List<Segment> segmentsTestFalse = new ArrayList<>();
        Segment segmentTestFalse = new Segment(departureTestFalse, arrivalTestFalse);
        segmentsTestFalse.add(segmentTestFalse);
        Flight flightTestFalse = new Flight(segmentsTestFalse);

        List<Flight> flightsTest = new ArrayList<>();
        flightsTest.add(flightTestTrue);
        flightsTest.add(flightTestFalse);

        FilterArrivalBeforeDeparture filterArrivalBeforeDeparture = new FilterArrivalBeforeDeparture();
        List<Flight> resultTest = filterArrivalBeforeDeparture.filterFlights(flightsTest);
        assertEquals(1, resultTest.size());

    }

    @Test
    void validFlight() {

        LocalDateTime departureTestTrue = LocalDateTime.parse("2025-06-05T20:00");
        LocalDateTime arrivalTestTrue = LocalDateTime.parse("2025-06-05T22:00");

        List<Segment> segmentsTestTrue = new ArrayList<>();
        Segment segment = new Segment(departureTestTrue, arrivalTestTrue);
        segmentsTestTrue.add(segment);
        Flight flightTestTrue = new Flight(segmentsTestTrue);

        LocalDateTime departureTestFalse = LocalDateTime.parse("2025-06-05T22:00");
        LocalDateTime arrivalTestFalse = LocalDateTime.parse("2025-06-05T20:00");

        List<Segment> segmentsTestFalse = new ArrayList<>();
        Segment segmentTestFalse = new Segment(departureTestFalse, arrivalTestFalse);
        segmentsTestFalse.add(segmentTestFalse);
        Flight flightTestFalse = new Flight(segmentsTestFalse);

        FilterArrivalBeforeDeparture filterArrivalBeforeDepartureTest = new FilterArrivalBeforeDeparture();

        assertTrue(filterArrivalBeforeDepartureTest.validFlight(flightTestTrue));
        assertFalse(filterArrivalBeforeDepartureTest.validFlight(flightTestFalse));


    }
}