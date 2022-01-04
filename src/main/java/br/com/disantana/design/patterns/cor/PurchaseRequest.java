package br.com.disantana.design.patterns.cor;

public class PurchaseRequest {
    private final double amount;
    private final String purpose;

    public PurchaseRequest(double amount, String purpose) {
        this.amount = amount;
        this.purpose = purpose;
    }

    public double getAmount() {
        return amount;
    }

    public String getPurpose() {
        return purpose;
    }
}
