package br.com.disantana.design.patterns.observer.payments;

import java.math.BigDecimal;

public abstract class VirtualAccount implements Account {
    protected BigDecimal limit;
    protected BigDecimal amount;
    protected AccountStatusEnum accountStatus;

    abstract void increaseLimitTo(BigDecimal value);
    abstract void decreaseLimitTo(BigDecimal value);
    abstract void pay(BigDecimal value, VirtualAccount account);
    abstract void block();
}
