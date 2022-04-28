package model;

import java.util.List;

public interface Engine {
    boolean serverIsOnline();
    boolean signup(String username);
    boolean login(String username, String token);
    String getUserInfo();
    String getToken();
    String getAvailableLoans();
    String takeLoan();
    String getActiveLoans();
    String getAvailableShips();
    List<String> getAvailableShipsDropdown();
    String buyShip(String shipDetails);
    String getUserShips();
    String getNearbyLocations();
    List<String> getNearbyLocationSymbols();
    List<String> getCurrentLocations();
    String getMarketplace(String location);
    List<String> getGoodsNames(String location);
    List<String> getShipsByLocation(String location);
    List<String> getShipID();
    String buyGoods(String shipName, String goodsType, String amount);
    String sellGoods(String shipName, String goodsType, String amount);
    String travel(String shipName, String destination);
    String getCurrentFlightDetails();
}
