package br.com.disantana.design.patterns.cor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ManagerPurchasePowerTest {

    @InjectMocks
    PurchasePower manager;

    @Mock
    PurchasePower sucessor;

    @Before
    public void setUp() {
        manager = new ManagerPurchasePower();
    }

    @Test
    public void shouldBeAuthorizedByManager() {
        PurchaseRequest request = new PurchaseRequest(50, "Teste diretor");

        String approved = manager.processRequest(request);

        assertEquals("approved", approved);
    }

    @Test
    public void shouldBeInvalid() {
        PurchaseRequest request = new PurchaseRequest(0, "Invalid");
        String invalid = manager.processRequest(request);

        assertEquals("invalid", invalid);
    }

    @Test
    public void shouldCallSucessor() {
        MockitoAnnotations.openMocks(this);
        var unacceptableValue = manager.getAllowable() + 1;
        PurchaseRequest request = new PurchaseRequest(unacceptableValue, "Test");
        manager.processRequest(request);

        verify(sucessor, times(1)).processRequest(request);
    }
}