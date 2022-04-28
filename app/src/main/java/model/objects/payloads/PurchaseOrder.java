package model.objects.payloads;

public class PurchaseOrder {
    String shipId;
    String good;
    int quantity;

    public PurchaseOrder(String shipId, String good, int quantity) {
        this.shipId = shipId;
        this.good = good;
        this.quantity = quantity;
    }
}
