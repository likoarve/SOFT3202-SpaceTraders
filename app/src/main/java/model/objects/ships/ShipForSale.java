package model.objects.ships;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ShipForSale {
    @SerializedName("class")
    String shipClass;
    String manufacturer;
    int maxCargo;
    int plating;
    List<ShipListingsLocations> purchaseLocations;
    int speed;
    String type;
    int weapons;

    public String toString() {
        String result = String.format("""
                Class: %s
                Manufacturer: %s
                Maximum cargo: %d
                Number of plating: %d
                Speed: %d
                Type: %s
                Number of weapons: %d
                Purchase locations:
                """, shipClass, manufacturer, maxCargo, plating, speed, type, weapons);

        for (ShipListingsLocations location : purchaseLocations) {
            result += location.toString();
            result += "\n";
        }

        result += "\n";

        return result;
    }

    public String toShortString() {
        return String.format("%s %s (%s)", manufacturer, shipClass, type);
    }

    public String getType() {
        return type;
    }

    public List<ShipListingsLocations> getPurchaseLocations() {
        return purchaseLocations;
    }
}
