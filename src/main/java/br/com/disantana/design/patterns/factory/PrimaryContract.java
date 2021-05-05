package br.com.disantana.design.patterns.factory;

public class PrimaryContract extends ContractAbstract {
    public PrimaryContract() {
        this.type = ContractEnum.PRIMARY;
        this.expirationDate = "01/06/2022";
        this.owner = "BRB INC.";
    }
}
