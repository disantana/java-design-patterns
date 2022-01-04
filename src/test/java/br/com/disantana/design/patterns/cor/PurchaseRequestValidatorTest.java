package br.com.disantana.design.patterns.cor;

import org.junit.Assert;
import org.junit.Test;

public class PurchaseRequestValidatorTest extends Assert {

    @Test
    public void shouldReturnFalseWhenCheckRequest() {
        PurchaseRequest request = new PurchaseRequest(0, "purpose");
        var invalid = PurchaseRequestValidator.invalid(request);
        assertTrue(invalid);

        request = new PurchaseRequest(-1, "purpose");
        invalid = PurchaseRequestValidator.invalid(request);
        assertTrue(invalid);

        request = new PurchaseRequest(1000, null);
        invalid = PurchaseRequestValidator.invalid(request);
        assertTrue(invalid);

        request = new PurchaseRequest(1000, "");
        invalid = PurchaseRequestValidator.invalid(request);
        assertTrue(invalid);

        request = new PurchaseRequest(1000, "  ");
        invalid = PurchaseRequestValidator.invalid(request);
        assertTrue(invalid);
    }

    @Test
    public void shouldReturnTrueWhenCheckRequest() {
        PurchaseRequest request = new PurchaseRequest(100, "purpose");
        var invalid = PurchaseRequestValidator.invalid(request);
        assertFalse(invalid);
    }
}