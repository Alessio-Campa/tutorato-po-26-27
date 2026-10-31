package it.unive.dais.po.tutoring;

import it.unive.dais.po.tutoring.airport.vehicles.Airplane;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATC {
    static Map<String, List<Airplane>> airplaneMap = new HashMap<>();

    static public void listenLanding(Airplane plane, Airport airport) {
        if (airplaneMap.containsKey(airport.ICAO))
            airplaneMap.get(airport.ICAO).add(plane);
        else
            airplaneMap.put(airport.ICAO, List.of(plane));
    }

    static public void listenTakeoff(Airplane plane) {
        if (airplaneMap.containsKey(plane.getCurrentAirport().ICAO))
            airplaneMap.get(plane.getCurrentAirport().ICAO).remove(plane);
        else{
            throw new IllegalArgumentException("Airplane was not at specified airport");
        }
    }

    public static List<Airplane> getListFromAirport(Airport airport) {
        return airplaneMap.get(airport.ICAO);
    }
}
