package br.com.disantana.design.patterns.cor;

abstract class PurchasePower {
    protected static final double BASE = 100;
    protected PurchasePower sucessor;

    protected abstract double getAllowable();
    protected abstract String getRole();

    public PurchasePower getSucessor() {
        return sucessor;
    }

    public void setSucessor(PurchasePower sucessor) {
        this.sucessor = sucessor;
    }

    public String processRequest(PurchaseRequest request){
        if (request.getAmount() < this.getAllowable()){
            return this.getRole() + " will approve $ " + request.getAmount();
        } else if (sucessor != null){
            return sucessor.processRequest(request);
        }
        return "Cannot be approved.";
    }
}
