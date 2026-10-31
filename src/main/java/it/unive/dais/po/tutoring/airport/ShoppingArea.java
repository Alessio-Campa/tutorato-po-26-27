package it.unive.dais.po.tutoring.airport;

import java.util.ArrayList;
import java.util.List;

public class ShoppingArea extends AirportArea {
    List<Shop> shops = new ArrayList<>();

    public int numShops() {
        return shops.size();
    }
}
