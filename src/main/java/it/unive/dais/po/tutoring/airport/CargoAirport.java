package it.unive.dais.po.tutoring.airport;

public class CargoAirport extends Airport {
    public CargoAirport(String name, String ICAO, String city, String country, int numGates) {
        super(name, ICAO, city, country, numGates);
    }

    @Override
    public void boardPlane() {
        System.out.println("Boarding cargo plane");
    }
}
