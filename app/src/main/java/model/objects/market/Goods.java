package model.objects.market;

public class Goods {
    String symbol;
    int volumePerUnit;
    int pricePerUnit;
    int spread;
    int purchasePricePerUnit;
    int sellPricePerUnit;
    int quantityAvailable;

    public String toString() {
        return String.format("""
                Item name: %s
                Volume per unit: %d
                Price per unit: %d
                Spread: %d
                Purchase price: %d
                Sell price: %d
                Quantity available: %d
                
                """, symbol, volumePerUnit, pricePerUnit, spread, purchasePricePerUnit, sellPricePerUnit, quantityAvailable);
    }

    public String getSymbol() {
        return symbol;
    }
}
