package model.objects.location;

import javafx.scene.Parent;

import java.util.List;

public class LocationInfo {
    String symbol;
    String type;
    String name;
    int x;
    int y;
    boolean allowsConstruction;
    List<String> traits;

    public String getSymbol() {
        return this.symbol;
    }

    public String toString() {
        String result = String.format("""
                Symbol: %s
                Type: %s
                Name: %s
                Allows construction: %s
                Coordinates: x:%d y:%d
                Traits:
                """, symbol, type, name, allowsConstruction, x, y);

        if (traits.isEmpty()) {
            result = result.stripTrailing();
            result += " None";
        } else {
            for (String trait : traits) {
                result += "- " + trait + "\n";
            }
        }

        result += "\n";

        return result;
    }
}
