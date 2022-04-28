package model;

import java.util.Arrays;
import java.util.List;

public class OfflineEngine implements Engine {
    @Override
    public boolean serverIsOnline() {
        return true;
    }

    @Override
    public boolean signup(String username) {
        return true;
    }

    @Override
    public boolean login(String username, String token) {
        return true;
    }

    @Override
    public String getUserInfo() {
        return """
                Username: dummy
                Token: abcdefg
                Joined at: 2022-04-11T10:10:109Z
                Credits: 100000
                Ship Count: 1
                Structure Count: 0
                """;
    }

    @Override
    public String getToken() {
        return "abcdefg";
    }

    @Override
    public String getAvailableLoans() {
        return """
                1 loan(s) available.
                
                Type: STARTUP
                Amount: 20000
                Rate: 40
                Term (in days): 2
                Requires Collateral: false
                """;
    }

    @Override
    public String takeLoan() {
        return "Success";
    }

    @Override
    public String getActiveLoans() {
        return """
                You have 1 active loan.
                
                Type: STARTUP
                ID: joidnkjkfodvsnjdwov
                Repayment Amount: 280000
                Due: 2022-30-04T10:10:000Z
                Status: CURRENT
                """;
    }

    @Override
    public String getAvailableShips() {
        return """
                Class: MK-I
                Manufacturer: Jackshaw
                Maximum cargo: 50
                Number of plating: 5
                Speed: 1
                Type: JW-MK-I
                Number of weapons: 9
                Purchase locations:
                - OE-PM-TR | Price: 21125
                - OE-PM | Price: 21125
                """;
    }

    @Override
    public List<String> getAvailableShipsDropdown() {
        return Arrays.asList("JW-MK-I | OE-PM-TR", "JW-MK-I | OE-PM");
    }

    @Override
    public String buyShip(String shipDetails) {
        return "Success";
    }

    @Override
    public String getUserShips() {
        return """
                Cargo:
                - FUEL | Qty: 2 | Vol: 2
                - METALS | Qty: 5 | Vol: 10
                Class: MK-I
                Flight Plan ID: null
                Ship ID: somerandomthings
                Location: OE-PM-TR
                Manufacturer: Jackshaw
                Maximum cargo: 50
                Number of plating: 5
                Space available: 48
                Speed: 1
                Type: JW-MK-I
                Number of weapons: 5
                Coordinates: x:-20 y:5
                """;
    }

    @Override
    public String getNearbyLocations() {
        return """
                Symbol: OE-PM
                Type: Planet
                Name: Prime
                Allows construction: false
                Coordinates: x:-19 y:3
                Traits:
                - METAL_ORES
                - SOME_NATURAL_CHEMICALS
                
                Symbol: OE-PM-TR
                Type: Moon
                Name: Tritus
                Allows construction: false
                Coordinates: x:-20 y:5
                Traits:
                - NATURAL_CHEMICALS
                """;
    }

    @Override
    public List<String> getNearbyLocationSymbols() {
        return Arrays.asList("OE-PM-TR", "OE-PM");
    }

    @Override
    public List<String> getCurrentLocations() {
        return Arrays.asList("OE-PM-TR");
    }

    @Override
    public String getMarketplace(String location) {
        return """
                Item name: METALS
                Volume per unit: 1
                Price per unit: 4
                Spread: 1
                Purchase price: 5
                Sell price: 3
                Quantity available: 80000
                
                Item name: CONSTRUCTION_MATERIALS
                Volume per unit: 1
                Price per unit: 90
                Spread: 3
                Purchase price: 93
                Sell price: 87
                Quantity available: 20000
                """;
    }

    @Override
    public List<String> getGoodsNames(String location) {
        return Arrays.asList("METALS", "FUEL", "CONSTRUCTION_MATERIALS");
    }

    @Override
    public List<String> getShipsByLocation(String location) {
        return Arrays.asList("Jackshaw MK-I", "Jackshaw MK-II");
    }

    @Override
    public List<String> getShipID() {
        return Arrays.asList("Ship 1", "Ship 2", "Ship 3");
    }

    @Override
    public String buyGoods(String shipName, String goodsType, String amount) {
        return "Success";
    }

    @Override
    public String sellGoods(String shipName, String goodsType, String amount) {
        return "Success";
    }

    @Override
    public String travel(String shipName, String destination) {
        return "Success";
    }

    @Override
    public String getCurrentFlightDetails() {
        return "There are no active flights";
    }
}
