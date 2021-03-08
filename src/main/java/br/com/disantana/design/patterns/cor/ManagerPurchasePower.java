package br.com.disantana.design.patterns.cor;

public class ManagerPurchasePower extends PurchasePower{
    @Override
    protected double getAllowable() {
        return BASE * 10;
    }

    @Override
    protected String getRole() {
        return "Manager";
    }
}
