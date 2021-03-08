package br.com.disantana.design.patterns.cor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CEOPurchasePowerTest extends Assert {

    PurchasePower ceo = new CEOPurchasePower();

    @Before
    public void setUp() throws Exception {
        ceo.setSucessor(null);
    }

    @Test
    public void deveSerAutorizadoPeloCEO(){
        PurchaseRequest request = new PurchaseRequest(5000,"Teste CEO");

        String approved = ceo.processRequest(request);

        assertEquals("CEO Will analyze.", approved);

    }

}