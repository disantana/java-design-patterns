package br.com.disantana.design.patterns.cor;

public class CEOPurchasePower extends PurchasePower {

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
        if (PurchaseRequestValidator.invalid(request)) return "invalid";
        if (request.getAmount() < getAllowable()) return "approved";

        return null;
    }
}
