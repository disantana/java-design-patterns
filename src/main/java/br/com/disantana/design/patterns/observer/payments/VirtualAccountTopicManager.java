package br.com.disantana.design.patterns.observer.payments;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

public class VirtualAccountTopicManager implements AccountTopicManager {

    private final Set<VirtualAccount> topic;

    public VirtualAccountTopicManager() {
        topic = new HashSet<>();
    }

    @Override
    public boolean register(Account observer) {
        if (Objects.isNull(observer)) return false;
        if (observer instanceof VirtualAccount) {
            return topic.add((VirtualAccount) observer);
        }
        return false;
    }

    @Override
    public boolean unregister(Account observer) {
        if (Objects.isNull(observer) || topic.isEmpty()) return false;
        if (observer instanceof VirtualAccount) {
            return topic.remove((VirtualAccount) observer);
        }
        return false;
    }

    @Override
    public boolean updateTopic(Account observer) {
        if (Objects.isNull(topic) || topic.isEmpty()) return false;
        if (!(observer instanceof VirtualAccount)) return false;

        topic.forEach(account -> {
            account.limit = ((VirtualAccount) observer).limit;
            account.amount = ((VirtualAccount) observer).amount;
        });

        return true;
    }

    @Override
    public Account first() {
        if (Objects.isNull(topic) || topic.isEmpty()) return null;
        var account = topic.stream()
                .findFirst()
                .orElse(null);
        return (VirtualAccount) account;
    }


}
