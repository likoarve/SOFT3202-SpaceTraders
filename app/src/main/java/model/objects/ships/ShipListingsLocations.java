package model.objects.ships;

public class ShipListingsLocations {
    String location;
    int price;

    public String getLocation() {
        return this.location;
    }

    public String toString() {
        return String.format("- %s | Price: %d", location, price);
    }
}
