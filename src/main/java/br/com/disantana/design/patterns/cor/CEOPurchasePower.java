package br.com.disantana.design.patterns.cor;

public class CEOPurchasePower extends PurchasePower {

    public CEOPurchasePower() {
        this.setSucessor(new DirectorPurchasePower());
    }

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

        var isValid = !PurchaseRequestValidator.invalid(request);
        if (!isValid) return "invalid";
        if (request.getAmount() < getAllowable()) return "approved";

        return sucessor.processRequest(request);
    }
}
