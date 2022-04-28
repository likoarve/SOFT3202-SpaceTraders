package model.objects.ships;

import java.util.ArrayList;
import java.util.List;

public class AvailableShips {
    List<ShipForSale> shipListings;

    public List<ShipForSale> getShipListings() {
        return this.shipListings;
    }

    public List<String> shipsToString() {
        List<String> ships = new ArrayList<>();

        for (ShipForSale ship : shipListings) {
            for (ShipListingsLocations locations : ship.getPurchaseLocations()) {
                ships.add(String.format("%s | %s", ship.getType(), locations.getLocation()));
            }
        }

        return ships;
    }
}
