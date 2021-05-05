package br.com.disantana.design.patterns.factory;

public class ContractFactory {

    public ContractAbstract createContract(ContractEnum type) {
        ContractAbstract contract;
        if (ContractEnum.PARTIAL.equals(type)) {
            contract = new PartialContract();
        } else if(ContractEnum.FULL.equals(type)) {
            contract = new FullContract();
        } else {
            contract = new PrimaryContract();
        }
        return contract;
    }
}
