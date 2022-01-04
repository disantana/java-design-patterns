package br.com.disantana.design.patterns.cor;

public class DirectorPurchasePower extends PurchasePower{

    public DirectorPurchasePower() {
        setSucessor(new CEOPurchasePower());
    }

    @Override
    protected double getAllowable() {
        return BASE * 20;
    }

    @Override
    protected String getRole() {
        return "Director";
    }

    @Override
    public String processRequest(PurchaseRequest request) {
        if (PurchaseRequestValidator.invalid(request)) return "invalid";
        if (request.getAmount() < getAllowable()) return "approved";
        return sucessor.processRequest(request);
    }
}
