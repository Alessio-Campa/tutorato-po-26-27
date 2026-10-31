package it.unive.dais.po.tutoring.airport;

public final class InternationalAirport extends Airport {
    String localPoliceName;

    public int numInternationalGates(){
        return this.gateArea.numInternationalGates;
    }

    protected void printData(){
        System.out.println("International Airport: " + this.ICAO + " in " + this.city + ", " + this.country);
    }

    @Override
    public void boardPlane() {
        System.out.println("Boarding passenger plane");
    }

    public InternationalAirport(String name, String ICAO, String city, String country, int numGates, String localPoliceName) {
        super(name, ICAO, city, country, numGates);
        ((GateArea) this.areas[0]).numInternationalGates = 21;
        this.localPoliceName = localPoliceName;
    }
}

