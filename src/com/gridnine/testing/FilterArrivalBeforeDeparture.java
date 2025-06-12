package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FilterArrivalBeforeDeparture implements FilterFly {


    @Override
    public List<Flight> filterFlights(List<Flight> listFlights) {
        List<Flight> newListFlight = new ArrayList<>();
        System.out.println("Фильтр 1");
        for (Flight flight : listFlights) {
            if (validFlight(flight)) {
               newListFlight.add(flight);

                System.out.println("Перелет:"+" "+flight);

            }


        }

        return newListFlight;
    }


    public boolean validFlight(Flight flight) {

        for (Segment segment : flight.getSegments()) {

            if (!segment.getArrivalDate().isAfter(segment.getDepartureDate())){
                return false ;
            }

        }
        return true;

    }
}
