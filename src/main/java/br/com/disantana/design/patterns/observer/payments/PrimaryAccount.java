package br.com.disantana.design.patterns.observer.payments;

import java.math.BigDecimal;
import java.util.Objects;

public class PrimaryAccount extends VirtualAccount {

    private AccountTopicManager topicManager = null;

    public PrimaryAccount(BigDecimal amount, BigDecimal limit) {
        this.amount = amount;
        this.limit = limit;
        this.accountStatus = AccountStatusEnum.ACTIVE;
    }

    @Override
    public String update() {
        if (Objects.isNull(topicManager)) return null;
        topicManager.updateTopic(this);
        return null;
    }

    @Override
    public void setAccountTopicManager(AccountTopicManager topicManager) {
        if (Objects.isNull(this.topicManager)) {
            this.topicManager = topicManager;
        }
    }

    @Override
    void increaseLimitTo(BigDecimal value) {
        if (limit.compareTo(value) < 0) {
            limit = value;
        }

        update();
    }

    @Override
    void decreaseLimitTo(BigDecimal value) {
        if (limit.compareTo(value) > 0) {
            limit = value;
        }

        update();
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
