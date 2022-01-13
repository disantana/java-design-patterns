package br.com.disantana.design.patterns.observer.payments;

import java.math.BigDecimal;
import java.util.Objects;

public class DepedentAccount extends VirtualAccount {

    private AccountTopicManager topicManager = null;

    public DepedentAccount() {
        this.accountStatus = AccountStatusEnum.ACTIVE;
    }

    @Override
    public String update() {
        if (Objects.nonNull(topicManager)){
            var account = topicManager.first();
            if (account instanceof VirtualAccount) {
                this.amount = ((VirtualAccount) account).amount;
                this.limit = ((VirtualAccount) account).limit;
            }
        }
        return null;
    }

    @Override
    public void setAccountTopicManager(AccountTopicManager subject) {
        if (Objects.isNull(this.topicManager)) {
            this.topicManager = subject;
        }
    }

    @Override
    void increaseLimitTo(BigDecimal value) {
        throw new UnsupportedOperationException();
    }

    @Override
    void decreaseLimitTo(BigDecimal value) {
        throw new UnsupportedOperationException();
    }

    @Override
    void pay(BigDecimal value, VirtualAccount account) {
        account.amount.add(value);
        this.amount.subtract(value);
    }

    @Override
    void block() {
        this.accountStatus = AccountStatusEnum.BLOCKED;
    }
}
