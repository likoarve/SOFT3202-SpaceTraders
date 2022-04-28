package model.objects.location;

import model.objects.location.LocationInfo;

import java.util.ArrayList;
import java.util.List;

public class NearbyLocations {
    List<LocationInfo> locations;

    public List<LocationInfo> getLocations() {
        return this.locations;
    }

    public List<String> getLocationSymbols() {
        List<String> symbols = new ArrayList<>();

        for (LocationInfo locationInfo : this.locations) {
            symbols.add(locationInfo.getSymbol());
        }

        return symbols;
    }
}
