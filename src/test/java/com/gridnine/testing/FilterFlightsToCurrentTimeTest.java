package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FilterFlightsToCurrentTimeTest {

    @Test
    void filterFlights() {

        LocalDateTime departureTestTrue = LocalDateTime.parse("2025-07-05T20:00");
        LocalDateTime arrivalTestTrue = LocalDateTime.parse("2025-07-05T22:00");

        List<Segment> segmentsTestTrue = new ArrayList<>();
        Segment segment = new Segment(departureTestTrue, arrivalTestTrue);
        segmentsTestTrue.add(segment);
        Flight flightTestTrue = new Flight(segmentsTestTrue);

        LocalDateTime departureTestFalse = LocalDateTime.parse("2025-04-05T22:00");
        LocalDateTime arrivalTestFalse = LocalDateTime.parse("2025-04-05T20:00");

        List<Segment> segmentsTestFalse = new ArrayList<>();
        Segment segmentTestFalse = new Segment(departureTestFalse, arrivalTestFalse);
        segmentsTestFalse.add(segmentTestFalse);
        Flight flightTestFalse = new Flight(segmentsTestFalse);

        List<Flight> resultFlights = new ArrayList<>();
        resultFlights.add(flightTestTrue);
        resultFlights.add(flightTestFalse);

        FilterFlightsToCurrentTime filterFlightsToCurrentTime = new FilterFlightsToCurrentTime();
        List<Flight> filteredFlights = filterFlightsToCurrentTime.filterFlights(resultFlights);
        assertEquals(1,filteredFlights.size());


    }


    @Test
    void validFlight() {


        LocalDateTime now = LocalDateTime.now();

        LocalDateTime departureTestTrue = LocalDateTime.parse("2025-07-05T20:00");
        LocalDateTime arrivalTestTrue = LocalDateTime.parse("2025-07-05T22:00");

        List<Segment> segmentsTestTrue = new ArrayList<>();
        Segment segment = new Segment(departureTestTrue, arrivalTestTrue);
        segmentsTestTrue.add(segment);
        Flight flightTestTrue = new Flight(segmentsTestTrue);

        LocalDateTime departureTestFalse = LocalDateTime.parse("2025-04-05T22:00");
        LocalDateTime arrivalTestFalse = LocalDateTime.parse("2025-04-05T20:00");

        List<Segment> segmentsTestFalse = new ArrayList<>();
        Segment segmentTestFalse = new Segment(departureTestFalse, arrivalTestFalse);
        segmentsTestFalse.add(segmentTestFalse);
        Flight flightTestFalse = new Flight(segmentsTestFalse);

        FilterFlightsToCurrentTime filterFlightsToCurrentTime = new FilterFlightsToCurrentTime();
        boolean resultTrue = filterFlightsToCurrentTime.validFlight(flightTestTrue, now);
        boolean resultFolse = filterFlightsToCurrentTime.validFlight(flightTestFalse, now);
        assertTrue(resultTrue);
        assertFalse(resultFolse);


    }
}