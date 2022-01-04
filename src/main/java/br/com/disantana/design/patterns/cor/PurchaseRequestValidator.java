package br.com.disantana.design.patterns.cor;

import java.util.Objects;

public class PurchaseRequestValidator {

    private PurchaseRequestValidator() { }

    public static boolean invalid(PurchaseRequest request) {
        return (Objects.isNull(request) || hasInvalidAmount(request) || hasInvalidPurpose(request));
    }

    private static boolean hasInvalidPurpose(PurchaseRequest request) {
        return Objects.isNull(request.getPurpose()) || request.getPurpose().isBlank();
    }

    private static boolean hasInvalidAmount(PurchaseRequest request) {
        return request.getAmount() <= 0;
    }
}
