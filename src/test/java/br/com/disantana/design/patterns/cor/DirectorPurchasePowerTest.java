package br.com.disantana.design.patterns.cor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;

public class DirectorPurchasePowerTest {
    @InjectMocks
    private PurchasePower director;

    @Mock
    private PurchasePower sucessor;

    @Before
    public void setUp() {
        director = new DirectorPurchasePower();
        director.setSucessor(new CEOPurchasePower());
    }

    @Test
    public void shouldBeAuthorizedByDiretor() {
        PurchaseRequest request = new PurchaseRequest(1100, "Teste diretor");

        String approved = director.processRequest(request);

        assertEquals("approved", approved);
    }

    @Test
    public void shouldBeInvalid() {
        PurchaseRequest request = new PurchaseRequest(0, "Invalid");
        String invalid = director.processRequest(request);

        assertEquals("invalid", invalid);
    }

    @Test
    public void shouldCallSucessor() {
        MockitoAnnotations.openMocks(this);
        var unacceptableValue = director.getAllowable() + 1;
        PurchaseRequest request = new PurchaseRequest(unacceptableValue, "Test");
        director.processRequest(request);

        verify(sucessor, times(1)).processRequest(request);
    }

}