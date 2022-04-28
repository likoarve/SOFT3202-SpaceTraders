package model.objects.payloads;

public class TravelPlan {
    String shipId;
    String destination;

    public TravelPlan(String shipId, String destination) {
        this.shipId = shipId;
        this.destination = destination;
    }
}
