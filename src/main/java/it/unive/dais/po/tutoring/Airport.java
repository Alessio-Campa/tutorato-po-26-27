package it.unive.dais.po.tutoring;

import it.unive.dais.po.tutoring.airport.vehicles.Airplane;

import java.util.Set;

public class Airport {
    private String name;
    public final String ICAO;
    private int numRunways;
    private int numStalls;
    public final int id;
    private static int numAirports;

    static {
        numAirports = 0;
    }

    public Airport(String name, String ICAO, int numRunways, int numStalls) {
        if (numRunways < 1) {
            throw new IllegalArgumentException("Number of runways must be greater than 0.");
        }
        this.name = name;
        this.ICAO = ICAO;
        this.numStalls = numStalls;
        this.numRunways = numRunways;
        this.id = numAirports++;
        Airport.printData(this);
    }

    public Airport(String name, String ICAO, int numStalls) {
        this(name, ICAO, 1, numStalls);
    }

    /**
     * Copy constructor
     * @param airport The airport to clone
     */
    public Airport(Airport airport) {
        this(airport.name, airport.ICAO, airport.numRunways, airport.numStalls);
    }

    static void printData(Airport airport){
        System.out.print(airport.name);
        System.out.print(" ");
        System.out.print(airport.ICAO);
        System.out.print(" ");
        System.out.print(airport.id);
        System.out.println(" ");
        System.out.flush();
    }

    static void addRunway(Airport airport){
        airport.numRunways++; // side effect
    }

    public int getNumRunways() {
        return numRunways;
    }

    public static int getNumAirports() {
        return numAirports;
    }

    static void main(String[] args) {
        Airport vce = new Airport("Venezia Marco Polo", "VCE", 2, 120);
        // Airport jfk = new Airport("New York City Airport", "JFK", -5, 1200);

        Airport tsf = new Airport("Treviso Airport", "TSF", 120);
        // tsf = 0xFA03

        Airport tsfDeepCopy = new Airport(tsf);
        // tsfDeepCopy = 0x6B01

        Airport tsfShallowCopy = tsf;
        // tsfShallowCopy = tsf = 0xFA03

        Airport.addRunway(tsfShallowCopy); // updates also tsf
        Airport.addRunway(tsfDeepCopy); // does not update tsf

        // tsf = 0xFA03
        System.out.println(tsf.numRunways); // now two instead of 1
    }
}