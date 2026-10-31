package it.unive.dais.po.tutoring.airport;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public abstract class Airport {
    String name;
    String ICAO;
    String city;
    String country;
    AirportArea[] areas = new AirportArea[10];
    GateArea gateArea;
    ShoppingArea shoppingArea =  new ShoppingArea();

    final public int numGates(){
        return gateArea.numGates + gateArea.numInternationalGates;
    }

    protected void printData(){
        System.out.println("Airport: " + this.ICAO + " in " + this.city + ", " + this.country);
    }

    protected void printData(OutputStream stream) throws IOException {
        stream.write(("Airport: " + this.ICAO + " in " + this.city + ", " + this.country).getBytes(StandardCharsets.UTF_8));
    }

    abstract public void boardPlane(/*Plane plane*/);

    public Airport(String name, String ICAO, String city, String country, int numGates) {
        this.name = name;
        this.ICAO = ICAO;
        this.city = city;
        this.country = country;

        this.areas[0] = new GateArea(numGates, 0);
        ShoppingArea shoppingArea = new ShoppingArea();
        this.areas[1] = shoppingArea;

        shoppingArea.shops.add(new Shop("Apple store", "tech"));
    }

    static void startBoarding(Airport airport){
        System.out.println("Start Boarding Airport: " + airport.name);
        if (airport instanceof InternationalAirport tmp){
            System.out.println("Checks done by: " + tmp.localPoliceName);
        } else if (airport instanceof CargoAirport tmp){
            System.out.println("Loading cargo");
        }
        airport.boardPlane();
        System.out.println();
    }

    static void main() {
        Airport vce = new InternationalAirport("Venezia Marco Polo", "VCE", "Venice", "Italy", 10, "Polizia di stato");
        Airport fmc = new InternationalAirport(
                "Roma Fiumicino",
                "FMC",
                "Rome",
                "Italy",
                10,
                "Polizia di Stato"
        );

        Airport cargoAir = new CargoAirport("aaa","aaa","aaa","aaa",0);

        fmc.printData();
        cargoAir.printData();

        System.out.println(((ShoppingArea) fmc.areas[1]).numShops());

        Airport.startBoarding(fmc);
        Airport.startBoarding(cargoAir);
    }
}
