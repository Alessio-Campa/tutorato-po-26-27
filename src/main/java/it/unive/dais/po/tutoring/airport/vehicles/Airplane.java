package it.unive.dais.po.tutoring.airport.vehicles;

import it.unive.dais.po.tutoring.ATC;
import it.unive.dais.po.tutoring.Airport;
import it.unive.dais.po.tutoring.airport.Passenger;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.Math.min;

public class Airplane {
    public final String id;
    public final double maxFuel;
    private double fuel = 0;
    private Airport currentAirport;
    private String secretCockpitCode;

    public Airplane(String id, double maxFuel) {
        this.maxFuel = maxFuel;
        this.id = id;
    }

    void startBoarding(){
        System.out.println("Starting boarding");
    }

    void takeoff(){
        System.out.println("Taking off");
        ATC.listenTakeoff(this);
        this.currentAirport = null;
    }

    void land(Airport airport){
        System.out.println("Landing");
        ATC.listenLanding(this, airport);
        this.currentAirport = airport;
    }

    void printStats(){
        System.out.println("Fuel: " + fuel + " / "  + maxFuel);
    }

    public double getFuel() {
        return fuel;
    }

    protected void addFuel(double fuel) {
        this.fuel = min(this.fuel + fuel, this.maxFuel);
    }

    public Airport getCurrentAirport() {
        return currentAirport;
    }

    static void main() {
        Airport vce = new Airport("Venezia Marco Polo", "VCE", 2, 120);
        Airplane plane = new Airplane("A320", 42.0);
        plane.land(vce);
        plane.addFuel(12);
        Passenger passenger = new Passenger();

        passenger.currentAirplane = plane;

    }
}
