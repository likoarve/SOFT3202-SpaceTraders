package model.objects.ships;

public class Cargo {
    String good;
    int quantity;
    int totalVolume;

    public String toString() {
        return String.format("- %s | Qty: %d | Vol: %d", good, quantity, totalVolume);
    }
}
