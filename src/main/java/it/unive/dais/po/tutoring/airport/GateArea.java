package it.unive.dais.po.tutoring.airport;

public class GateArea extends AirportArea {
    int numGates;
    int numInternationalGates;

    public GateArea(int numGates, int numInternationalGates) {
        this.numGates = numGates;
        this.numInternationalGates = numInternationalGates;
    }
}
