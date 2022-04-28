package model.objects.flights;

public class FlightPlan {
    String arrivesAt;
    String createdAt;
    String departure;
    String destination;
    int distance;
    int fuelConsumed;
    int fuelRemaining;
    String id;
    String shipId;
    int timeRemainingInSeconds;

    public String toString() {
        return String.format("""
                Created at: %s
                Departure: %s
                Destination: %s
                Arrival: %s
                Distance: %d
                Fuel consumed: %d
                Fuel remaining: %d
                Flight ID: %s
                Ship ID: %s
                Time remaining: %d seconds
                """, createdAt, departure, destination, arrivesAt, distance,
                fuelConsumed, fuelRemaining, id, shipId, timeRemainingInSeconds);
    }
}
