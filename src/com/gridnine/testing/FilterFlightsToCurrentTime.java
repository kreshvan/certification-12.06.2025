package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterFlightsToCurrentTime implements FilterFly {


    @Override
    public List<Flight> filterFlights(List<Flight> listFlights) {
        LocalDateTime now = LocalDateTime.now();
        List<Flight> resultNewFlight = new ArrayList<>();
        System.out.println("Фильтр 2");
        for (Flight flight : listFlights) {


            if (validFlight(flight, now)) {
                resultNewFlight.add(flight);

            }
        }
        for (Flight resultFight : resultNewFlight) {
            System.out.println("Перелет:"+" "+resultFight);
        }
        return resultNewFlight;
    }

    public boolean validFlight(Flight flight, LocalDateTime now) {
        for (Segment segment : flight.getSegments()) {
            if (segment.getDepartureDate().isBefore(now)) {
                return false;

            }
        }
        return true;
    }


}
