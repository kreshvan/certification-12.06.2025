package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.MINUTES;

public class TimeBetweenFlightsMoreTwoHours implements FilterFly {
    @Override
    public List<Flight> filterFlights(List<Flight> listFlights) {

        List<Flight> resultNewFlight = new ArrayList<>();
        System.out.println("Фильтр 3");
        for (Flight flight : listFlights) {
            if (validFlight(flight)) {

                resultNewFlight.add(flight);



                System.out.println("Перелет:"+" "+flight);
            }
        }
        return resultNewFlight;
    }


    public boolean validFlight(Flight flight) {
        long totalTimeOnGround = 0;

        for (int i = 0; i < flight.getSegments().size() - 1; i++) {

            Segment current = flight.getSegments().get(i);
            Segment next = flight.getSegments().get(i + 1);
            LocalDateTime timeArrivalOneSegment = current.getArrivalDate();
            LocalDateTime timeDepartureTwoSegment = next.getDepartureDate();

            long permissibleTimeOnGround = timeArrivalOneSegment.until
                    (timeDepartureTwoSegment, ChronoUnit.MINUTES);

            totalTimeOnGround += permissibleTimeOnGround;
        }
        if (totalTimeOnGround <= 120) {
            return true;
        } else {
            return false;
        }
    }

}

