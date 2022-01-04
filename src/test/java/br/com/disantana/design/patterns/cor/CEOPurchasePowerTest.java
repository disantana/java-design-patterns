package br.com.disantana.design.patterns.cor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CEOPurchasePowerTest {

    @InjectMocks
    private PurchasePower ceo;

    @Mock
    private PurchasePower sucessor;

    @Before
    public void setUp() {
        ceo = new CEOPurchasePower();
    }

    @Test
    public void shouldBeAuthorizedByCEO() {
        PurchaseRequest request = new PurchaseRequest(50, "Teste CEO");

        String approved = ceo.processRequest(request);

        assertEquals("approved", approved);
    }

    @Test
    public void shouldBeInvalid() {
        PurchaseRequest request = new PurchaseRequest(0, "Invalid");
        String invalid = ceo.processRequest(request);

        assertEquals("invalid", invalid);
    }

    @Test
    public void shouldCallSucessor() {
        MockitoAnnotations.openMocks(this);
        PurchaseRequest request = new PurchaseRequest(500000, "Invalid");
        ceo.processRequest(request);

        verify(sucessor, times(1)).processRequest(request);
    }

}