package model.objects.loan;

public class Loan {
    int amount;
    boolean collateralRequired;
    int rate;
    int termInDays;
    String type;

    public int getAmount() {
        return amount;
    }

    public boolean isCollateralRequired() {
        return collateralRequired;
    }

    public int getRate() {
        return rate;
    }

    public int getTermInDays() {
        return termInDays;
    }

    public String getType() {
        return type;
    }
}
