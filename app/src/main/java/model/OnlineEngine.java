package model;

import com.google.gson.Gson;
import model.objects.errors.Errors;
import model.objects.flights.FlightInfo;
import model.objects.loan.ActiveLoan;
import model.objects.loan.AvailableLoans;
import model.objects.loan.CurrentLoans;
import model.objects.loan.Loan;
import model.objects.location.LocationInfo;
import model.objects.location.NearbyLocations;
import model.objects.market.Goods;
import model.objects.market.Marketplace;
import model.objects.payloads.LoanType;
import model.objects.payloads.PurchaseOrder;
import model.objects.payloads.PurchaseShip;
import model.objects.payloads.TravelPlan;
import model.objects.ships.AvailableShips;
import model.objects.ships.ShipDetails;
import model.objects.ships.ShipForSale;
import model.objects.ships.UserShips;
import model.objects.user.User;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class OnlineEngine implements Engine {
    private String username;
    private String token;

    @Override
    public String getToken() {
        return this.token;
    }

    @Override
    public boolean serverIsOnline() {
        try {
            String responseBody = Requests.getRequest("https://api.spacetraders.io/game/status").body();
            Map<String, String> map = new Gson().fromJson(responseBody, Map.class);
            String status = map.get("status");

            return status.equals("spacetraders is currently online and available to play");
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean signup(String username) {
        String uri = String.format("https://api.spacetraders.io/users/%s/claim", username);
        HttpResponse<String> response = Requests.postRequest(uri, "");

        if (response.statusCode() == 201) {
            String responseBody = response.body();
            Map<String, String> map = new Gson().fromJson(responseBody, Map.class);
            this.username = username;
            this.token = map.get("token");

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean login(String username, String token) {
        String uri = String.format("https://api.spacetraders.io/my/account?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);

        if (response.statusCode() != 200) {
            return false;
        } else {
            String responseBody = response.body();
            User body = new Gson().fromJson(responseBody, User.class);
            String correctUsername = body.getUsername();

            if (username.equals(correctUsername)) {
                this.username = username;
                this.token = token;
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public String getUserInfo() {
        String uri = String.format("https://api.spacetraders.io/my/account?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        String responseBody = response.body();
        User body = new Gson().fromJson(responseBody, User.class);

        String info = String.format("Username: %s\n", this.username);
        info += String.format("Token: %s\n\n", this.token);
        info += String.format("Joined at: %s\n", body.getUser().getJoinedAt());
        info += String.format("Credits: %d\n", body.getUser().getCredits());
        info += String.format("Ship Count: %d\n", body.getUser().getShipCount());
        info += String.format("Structure Count: %d\n", body.getUser().getStructureCount());

        return info;
    }

    @Override
    public String getAvailableLoans() {
        String uri = String.format("https://api.spacetraders.io/types/loans?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        AvailableLoans loans = new Gson().fromJson(response.body(), AvailableLoans.class);

        StringBuilder allLoans = new StringBuilder(String.format("%d loan(s) available.\n\n", loans.getLoans().size()));

        for (Loan loan : loans.getLoans()) {
           allLoans.append(String.format("""
                           Type: %s
                           Amount: %d
                           Rate: %d
                           Term (in days): %d
                           Requires Collateral: %s\n\n
                           """,
                   loan.getType(),
                   loan.getAmount(),
                   loan.getRate(),
                   loan.getTermInDays(),
                   loan.isCollateralRequired()));
        }

        return allLoans.toString().stripTrailing();
    }

    @Override
    public String takeLoan() {
        LoanType loanType = new LoanType("STARTUP");
        String postJSON = new Gson().toJson(loanType);
        String uri = String.format("https://api.spacetraders.io/my/loans?token=%s", token);

        HttpResponse<String> response = Requests.postRequest(uri, postJSON);

        if (response.statusCode() >= 400) {
            Errors errors = new Gson().fromJson(response.body(), Errors.class);
            return errors.getMessage();
        } else {
            return "Success";
        }
    }

    @Override
    public String getActiveLoans() {
        String uri = String.format("https://api.spacetraders.io/my/loans?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        CurrentLoans loans = new Gson().fromJson(response.body(), CurrentLoans.class);

        StringBuilder allLoans = new StringBuilder(String.format("You have %d active loan.\n\n", loans.getLoans().size()));

        for (ActiveLoan loan : loans.getLoans()) {
            allLoans.append(String.format("""
                            Type: %s
                            ID: %s
                            Repayment Amount: %d
                            Due: %s
                            Status: %s
                            """,
                    loan.getType(),
                    loan.getId(),
                    loan.getRepaymentAmount(),
                    loan.getDue(),
                    loan.getStatus()));
        }

        return allLoans.toString().stripTrailing();
    }

    @Override
    public String getAvailableShips() {
        String uri = String.format("https://api.spacetraders.io/systems/OE/ship-listings?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        AvailableShips ships = new Gson().fromJson(response.body(), AvailableShips.class);
        StringBuilder allShips = new StringBuilder();

        for (ShipForSale ship : ships.getShipListings()) {
            allShips.append(ship.toString());
        }

        return allShips.toString().stripTrailing();
    }

    @Override
    public List<String> getAvailableShipsDropdown() {
        String uri = String.format("https://api.spacetraders.io/systems/OE/ship-listings?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        AvailableShips ships = new Gson().fromJson(response.body(), AvailableShips.class);

        return ships.shipsToString();
    }

    @Override
    public String buyShip(String shipDetails) {
        String shipType = shipDetails.split(" ")[0];
        String shipLocation = shipDetails.split(" ")[2];

        PurchaseShip purchaseShip = new PurchaseShip(shipLocation, shipType);
        String postJSON = new Gson().toJson(purchaseShip);
        String uri = String.format("https://api.spacetraders.io/my/ships?token=%s", token);

        HttpResponse<String> response = Requests.postRequest(uri, postJSON);

        if (response.statusCode() >= 400) {
            Errors errors = new Gson().fromJson(response.body(), Errors.class);
            return errors.getMessage();
        } else {
            return "Success";
        }
    }

    @Override
    public String getUserShips() {
        String uri = String.format("https://api.spacetraders.io/my/ships?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        UserShips ships = new Gson().fromJson(response.body(), UserShips.class);
        StringBuilder allShips = new StringBuilder();

        for (ShipDetails ship : ships.getShips()) {
            allShips.append(ship.toString());
        }

        String result = allShips.toString().stripTrailing();

        if (result.isEmpty()) {
            return "You have no ships. Purchase some ships to travel through space!";
        } else {
            return result;
        }
    }

    @Override
    public String getNearbyLocations() {
        String uri = String.format("https://api.spacetraders.io/systems/OE/locations?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        NearbyLocations locations = new Gson().fromJson(response.body(), NearbyLocations.class);
        StringBuilder allLocations = new StringBuilder();

        for (LocationInfo info : locations.getLocations()) {
            allLocations.append(info.toString());
        }

        return allLocations.toString().stripTrailing();
    }

    @Override
    public List<String> getNearbyLocationSymbols() {
        String uri = String.format("https://api.spacetraders.io/systems/OE/locations?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        NearbyLocations locations = new Gson().fromJson(response.body(), NearbyLocations.class);

        return locations.getLocationSymbols();
    }

    @Override
    public List<String> getCurrentLocations() {
        String uri = String.format("https://api.spacetraders.io/my/ships?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        UserShips ships = new Gson().fromJson(response.body(), UserShips.class);

        return ships.getAllLocations();
    }

    @Override
    public String getMarketplace(String location) {
        if (location == null) {
            return "You must have a ship to visit a marketplace.";
        }

        String uri = String.format("https://api.spacetraders.io/locations/%s/marketplace?token=%s", location, token);
        HttpResponse<String> response = Requests.getRequest(uri);
        Marketplace market = new Gson().fromJson(response.body(), Marketplace.class);
        StringBuilder allGoods = new StringBuilder();

        for (Goods good : market.getMarketplace()) {
            allGoods.append(good.toString());
        }

        return allGoods.toString().stripTrailing();
    }

    @Override
    public List<String> getGoodsNames(String location) {
        String uri = String.format("https://api.spacetraders.io/locations/%s/marketplace?token=%s", location, token);
        HttpResponse<String> response = Requests.getRequest(uri);
        Marketplace market = new Gson().fromJson(response.body(), Marketplace.class);

        return market.getGoodsNames();
    }

    @Override
    public List<String> getShipsByLocation(String location) {
        String uri = String.format("https://api.spacetraders.io/my/ships?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        UserShips ships = new Gson().fromJson(response.body(), UserShips.class);

        return ships.getShipByLocation(location);
    }

    @Override
    public List<String> getShipID() {
        String uri = String.format("https://api.spacetraders.io/my/ships?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        UserShips ships = new Gson().fromJson(response.body(), UserShips.class);

        return ships.getShipByLocation("all");
    }

    @Override
    public String buyGoods(String shipName, String goodsType, String amount) {
        String[] shipInfo = shipName.split(" ");
        String shipId = shipInfo[shipInfo.length - 1];

        PurchaseOrder purchaseOrder = new PurchaseOrder(shipId, goodsType, Integer.parseInt(amount));
        String postJSON = new Gson().toJson(purchaseOrder);
        String uri2 = String.format("https://api.spacetraders.io/my/purchase-orders?token=%s", token);

        HttpResponse<String> response2 = Requests.postRequest(uri2, postJSON);

        if (response2.statusCode() >= 400) {
            Errors errors = new Gson().fromJson(response2.body(), Errors.class);
            return errors.getMessage();
        } else {
            return "Success";
        }
    }

    @Override
    public String sellGoods(String shipName, String goodsType, String amount) {
        String[] shipInfo = shipName.split(" ");
        String shipId = shipInfo[shipInfo.length - 1];

        PurchaseOrder purchaseOrder = new PurchaseOrder(shipId, goodsType, Integer.parseInt(amount));
        String postJSON = new Gson().toJson(purchaseOrder);
        String uri2 = String.format("https://api.spacetraders.io/my/sell-orders?token=%s", token);

        HttpResponse<String> response2 = Requests.postRequest(uri2, postJSON);

        if (response2.statusCode() >= 400) {
            Errors errors = new Gson().fromJson(response2.body(), Errors.class);
            return errors.getMessage();
        } else {
            return "Success";
        }
    }

    @Override
    public String travel(String shipName, String destination) {
        String[] shipInfo = shipName.split(" ");
        String shipId = shipInfo[shipInfo.length - 1];

        TravelPlan travelPlan = new TravelPlan(shipId, destination);
        String postJSON = new Gson().toJson(travelPlan);
        String uri2 = String.format("https://api.spacetraders.io/my/flight-plans?token=%s", token);

        HttpResponse<String> response2 = Requests.postRequest(uri2, postJSON);

        if (response2.statusCode() >= 400) {
            Errors errors = new Gson().fromJson(response2.body(), Errors.class);
            return errors.getMessage();
        } else {
            return "Success";
        }
    }

    @Override
    public String getCurrentFlightDetails() {
        String uri = String.format("https://api.spacetraders.io/my/ships?token=%s", token);
        HttpResponse<String> response = Requests.getRequest(uri);
        UserShips ships = new Gson().fromJson(response.body(), UserShips.class);

        List<String> flightIds = ships.getAllFlightId();

        if (flightIds.size() == 0) {
            return "No active flights.";
        } else {
            StringBuilder result = new StringBuilder();

            for (String flightId : flightIds) {
                String uri2 = String.format("https://api.spacetraders.io/my/flight-plans/%s?token=%s", flightId, token);
                HttpResponse<String> response2 = Requests.getRequest(uri2);
                FlightInfo info = new Gson().fromJson(response2.body(), FlightInfo.class);

                result.append(info.toString()).append("\n");
            }

            return result.toString().stripTrailing();
        }
    }
}
