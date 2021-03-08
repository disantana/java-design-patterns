package br.com.disantana.design.patterns.cor;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectorPurchasePowerTest extends Assert
{
    PurchasePower director;

    @Before
    public void setUp() throws Exception {
        director = new DirectorPurchasePower();
       director.setSucessor(new CEOPurchasePower());
    }

    @Test
    public void deveSerAutorizadoPorDiretor(){
        PurchaseRequest request = new PurchaseRequest(1100, "Teste diretor");

        String approvedByDirector = director.processRequest(request);

        assertEquals("Director will approve $ 1100.0",  approvedByDirector);
    }

    @Test
    public void deveSerAprovadoPorCEO(){
        PurchaseRequest request = new PurchaseRequest(2100, "Teste CEO");

        String approvedByCEO = director.processRequest(request);

        assertEquals("CEO Will analyze.", approvedByCEO);
    }

}