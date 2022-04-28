package model.objects.loan;

public class ActiveLoan {
    String due;
    String id;
    int repaymentAmount;
    String status;
    String type;

    public String getDue() {
        return due;
    }

    public String getId() {
        return id;
    }

    public int getRepaymentAmount() {
        return repaymentAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }
}
