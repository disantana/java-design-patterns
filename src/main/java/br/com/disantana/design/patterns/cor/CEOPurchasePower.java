package br.com.disantana.design.patterns.cor;

public class CEOPurchasePower extends PurchasePower{
    @Override
    protected double getAllowable() {
        return BASE * 30;
    }

    @Override
    protected String getRole() {
        return "CEO";
    }

    @Override
    public String processRequest(PurchaseRequest request) {

        return "CEO Will analyze.";
    }
}
