package model.objects.ships;

import com.google.gson.annotations.SerializedName;
import model.objects.ships.Cargo;

import java.util.List;

public class ShipDetails {
    List<Cargo> cargo;
    @SerializedName("class")
    String shipClass;
    String flightPlanId;
    String id;
    String location;
    String manufacturer;
    int maxCargo;
    int plating;
    int spaceAvailable;
    int speed;
    String type;
    int weapons;
    int x;
    int y;

    public String toString() {
        String cargos = "";
        for (Cargo cargo : this.cargo) {
            cargos +=  "\n" + cargo.toString();
        }

        String result = String.format("""
                Cargo: %s
                Class: %s
                Flight Plan ID: %s
                Ship ID: %s
                Location: %s
                Manufacturer: %s
                Maximum cargo: %d
                Number of plating: %d
                Space available: %d
                Speed: %d
                Type: %s
                Number of weapons: %d
                Coordinates: x:%d y:%d 
                """, cargos, shipClass, flightPlanId, id, location, manufacturer, maxCargo, plating,
                spaceAvailable, speed, type, weapons, x, y);

        result += "\n";

        return result;
    }

    public String getLocation() {
        return this.location;
    }

    public String getFlightPlanId() {
        return this.flightPlanId;
    }

    public String getName() {
        return String.format("%s | ID: %s", type, id);
    }

    public String getId() {
        return id;
    }
}
