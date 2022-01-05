package br.com.disantana.design.patterns.cor;

public class ManagerPurchasePower extends PurchasePower{

    public ManagerPurchasePower() {
        setSucessor(new DirectorPurchasePower());
    }

    @Override
    protected double getAllowable() {
        return BASE * 10;
    }

    @Override
    protected String getRole() {
        return "Manager";
    }

    @Override
    public String processRequest(PurchaseRequest request) {
        if (PurchaseRequestValidator.invalid(request)) return "invalid";
        if (request.getAmount() < getAllowable()) return "approved";
        return sucessor.processRequest(request);
    }
}
