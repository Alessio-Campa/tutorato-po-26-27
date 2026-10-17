package it.unive.dais.po.tutoring.airport;

import it.unive.dais.po.tutoring.Airport;
import it.unive.dais.po.tutoring.airport.vehicles.Airplane;

public class Passenger {
    public Airplane currentAirplane;
    private String appPassword;

    public void tamperWithPlane(){
//        currentAirplane.fuel -= 10; // Fuel is private
    }

    public void panicCheckFuel(){
        if (currentAirplane.getFuel() == currentAirplane.maxFuel){
            System.out.println("Kalm");
        } else {
            System.out.println("Panik");
        }
    }

    public void meet(Passenger other){
        System.out.println(other.appPassword); // valid code
    }

}
