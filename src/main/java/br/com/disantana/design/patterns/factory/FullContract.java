package br.com.disantana.design.patterns.factory;

public class FullContract extends ContractAbstract {

    public FullContract() {
        this.type = ContractEnum.FULL;
        this.expirationDate = "01/12/2022";
        this.owner = "BRC INC.";
    }
}
