package br.com.disantana.design.patterns.factory;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;

public class ContractFactoryTest extends Assert {

    private ContractFactory factory = new ContractFactory();

    @Test
    public void createFullContract() {
        ContractAbstract fullcontract = factory.createContract(ContractEnum.FULL);
        assertEquals(fullcontract.type, ContractEnum.FULL);
        assertEquals(fullcontract.owner, "BRC INC.");
    }

    @Test
    public void createPartialContract() {
        PartialContract fullcontract = (PartialContract) factory.createContract(ContractEnum.PARTIAL);
        assertEquals(fullcontract.type, ContractEnum.PARTIAL);
        assertEquals(fullcontract.owner, "BRA INC.");
        assertEquals(fullcontract.getPendentInformation(), "Zip code, Maximum amount ...");
    }

    @Test
    public void createPrimaryContract() {
        ContractAbstract fullcontract = factory.createContract(ContractEnum.PRIMARY);
        assertEquals(fullcontract.type, ContractEnum.PRIMARY);
        assertEquals(fullcontract.owner, "BRB INC.");
    }
}