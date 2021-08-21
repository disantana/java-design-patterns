package br.com.disantana.design.patterns.cor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CEOPurchasePowerTest  {

    PurchasePower ceo = new CEOPurchasePower();

    @Before
    public void setUp() {
        ceo.setSucessor(null);
    }

    @Test
    public void deveSerAutorizadoPeloCEO(){
        PurchaseRequest request = new PurchaseRequest(5000,"Teste CEO");

        String approved = ceo.processRequest(request);

        assertEquals("CEO Will analyze.", approved);

    }

}