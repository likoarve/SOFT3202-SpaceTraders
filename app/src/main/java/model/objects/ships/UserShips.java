package model.objects.ships;

import model.objects.ships.ShipDetails;

import java.util.ArrayList;
import java.util.List;

public class UserShips {
    List<ShipDetails> ships;

    public List<ShipDetails> getShips() {
        return this.ships;
    }

    public List<String> getAllFlightId() {
        List<String> flightIds = new ArrayList<>();

        for (ShipDetails ship : ships) {
            if (ship.getFlightPlanId() != null) {
                flightIds.add(ship.getFlightPlanId());
            }
        }

        return flightIds;
    }

    public List<String> getAllLocations() {
        List<String> locations = new ArrayList<>();

        for (ShipDetails ships : this.ships) {
            if (!locations.contains(ships.getLocation()) && ships.getFlightPlanId() == null) {
                locations.add(ships.getLocation());
            }
        }

        return locations;
    }

    public List<String> getShipByLocation(String location) {
        List<String> shipNames = new ArrayList<>();

        for (ShipDetails ship : this.ships) {
            if (ship.getLocation() != null && (location.equals("all") || ship.getLocation().equals(location))) {
                shipNames.add(ship.getName());
            }
        }

        return shipNames;
    }

    public String getIdByName(String name) {
        for (ShipDetails ship : this.ships) {
            if (name.equals(ship.getName())) {
                return ship.getId();
            }
        }

        return null;
    }
}
