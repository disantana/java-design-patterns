package br.com.disantana.design.patterns.factory;

public class PartialContract extends ContractAbstract {

    private String pendentInformation;

    public PartialContract() {
        this.type = ContractEnum.PARTIAL;
        this.expirationDate = "01/01/2022";
        this.owner = "BRA INC.";
        this.pendentInformation = "Zip code, Maximum amount ...";
    }

    public String getPendentInformation() {
        return this.pendentInformation;
    }
}
