package com.gridnine.testing;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TimeBetweenFlightsMoreTwoHoursTest {

    @Test
    void filterFlights() {
        LocalDateTime timeDepartureTestOneTrue = LocalDateTime.parse("2025-07-05T20:00");
        LocalDateTime timeArrivalTestOneTrue = LocalDateTime.parse("2025-07-05T22:00");
        Segment segmentTestOneTrue = new Segment(timeDepartureTestOneTrue, timeArrivalTestOneTrue);

        LocalDateTime timeDepartureSegmentTwoTrue = LocalDateTime.parse("2025-07-05T23:50");
        LocalDateTime timeArrivalSegmentTwoTrue = LocalDateTime.parse("2025-08-05T20:00");
        Segment segmentTestTwoTrue = new Segment(timeDepartureSegmentTwoTrue, timeArrivalSegmentTwoTrue);

        List<Segment> segments = new ArrayList<>();
        segments.add(segmentTestOneTrue);
        segments.add(segmentTestTwoTrue);
        Flight flightTestTrue = new Flight(segments);

        LocalDateTime timeDepartureTestOneFalse = LocalDateTime.parse("2025-07-05T20:00");
        LocalDateTime timeArrivalTestOneFalse = LocalDateTime.parse("2025-07-05T22:00");
        Segment segmentTestOneFalse = new Segment(timeDepartureTestOneFalse, timeArrivalTestOneFalse);

        LocalDateTime timeDepartureSegmentTwoFalse = LocalDateTime.parse("2025-08-05T23:50");
        LocalDateTime timeArrivalSegmentTwoFalse = LocalDateTime.parse("2025-08-05T20:00");
        Segment segmentTestTwoFalse = new Segment(timeDepartureSegmentTwoFalse, timeArrivalSegmentTwoFalse);

        List<Segment> segmentsFalse = new ArrayList<>();
        segmentsFalse.add(segmentTestOneFalse);
        segmentsFalse.add(segmentTestTwoFalse);
        Flight flightTestFalse = new Flight(segmentsFalse);
        List<Flight> listFlightTest = new ArrayList<>();
        listFlightTest.add(flightTestTrue);
        listFlightTest.add(flightTestFalse);

        TimeBetweenFlightsMoreTwoHours timeBetweenFlightsMoreTwoHours = new TimeBetweenFlightsMoreTwoHours();
        List<Flight> flightsResult = timeBetweenFlightsMoreTwoHours.filterFlights(listFlightTest);
        assertEquals(1, flightsResult.size());

    }


    @Test
    void validFlight() {

        LocalDateTime timeDepartureTestOne = LocalDateTime.parse("2025-07-05T20:00");
        LocalDateTime timeArrivalTestOne = LocalDateTime.parse("2025-07-05T22:00");
        Segment segmentTestOne = new Segment(timeDepartureTestOne, timeArrivalTestOne);

        LocalDateTime timeDepartureSegmentTwo = LocalDateTime.parse("2025-07-05T23:50");
        LocalDateTime timeArrivalSegmentTwo = LocalDateTime.parse("2025-08-05T20:00");
        Segment segmentTestTwo = new Segment(timeDepartureSegmentTwo, timeArrivalSegmentTwo);

        List<Segment> segments = new ArrayList<>();
        segments.add(segmentTestOne);
        segments.add(segmentTestTwo);
        Flight flightTest = new Flight(segments);

        LocalDateTime timeDepartureTestOneFalse = LocalDateTime.parse("2025-07-05T20:00");
        LocalDateTime timeArrivalTestOneFalse = LocalDateTime.parse("2025-07-05T22:00");
        Segment segmentTestOneFalse = new Segment(timeDepartureTestOneFalse, timeArrivalTestOneFalse);

        LocalDateTime timeDepartureSegmentTwoFalse = LocalDateTime.parse("2025-08-05T23:50");
        LocalDateTime timeArrivalSegmentTwoFalse = LocalDateTime.parse("2025-08-05T20:00");
        Segment segmentTestTwoFalse = new Segment(timeDepartureSegmentTwoFalse, timeArrivalSegmentTwoFalse);

        List<Segment> segmentsFalse = new ArrayList<>();
        segmentsFalse.add(segmentTestOneFalse);
        segmentsFalse.add(segmentTestTwoFalse);
        Flight flightTestFalse = new Flight(segmentsFalse);


        TimeBetweenFlightsMoreTwoHours timeBetweenFlightsMoreTwoHoursTrue = new TimeBetweenFlightsMoreTwoHours();
        boolean resultTestTrue = timeBetweenFlightsMoreTwoHoursTrue.validFlight(flightTest);

        TimeBetweenFlightsMoreTwoHours timeBetweenFlightsMoreTwoHoursFalse = new TimeBetweenFlightsMoreTwoHours();
        boolean resultTestFalse = timeBetweenFlightsMoreTwoHoursFalse.validFlight(flightTestFalse);

        assertTrue(resultTestTrue);
        assertFalse(resultTestFalse);


    }
}