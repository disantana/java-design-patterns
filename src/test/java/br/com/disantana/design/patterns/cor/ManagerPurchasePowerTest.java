package br.com.disantana.design.patterns.cor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ManagerPurchasePowerTest {

    PurchasePower manager = new ManagerPurchasePower();

    @Before
    public void setUp() {
        manager.setSucessor(new DirectorPurchasePower());
    }

    @Test
    public void deveSerAutorizadoPorManager() {
        PurchaseRequest request = new PurchaseRequest(90, "Teste Manager");
        String approvedByManager = manager.processRequest(request);

        assertEquals("Manager will approve $ 90.0", approvedByManager);
    }

    @Test
    public void deveSerAutorizadoPorDirector() {
        PurchaseRequest request = new PurchaseRequest(1100, "Teste Director");
        String approvedByManager = manager.processRequest(request);

        assertEquals("Director will approve $ 1100.0", approvedByManager);
    }
}