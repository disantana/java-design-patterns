package br.com.disantana.design.patterns.observer.payments;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class VirtualAccountTopicManagerTest {

    @Test
    public void shouldRegisterVirtualAccountOnTopic() {
        var topic = new VirtualAccountTopicManager();
        VirtualAccount account = new PrimaryAccount(BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
        assertTrue(topic.register(account));
    }

    @Test
    public void shouldNotRegisterVirtualAccountOnTopic() {
        var topic = new VirtualAccountTopicManager();
        Account account = new AccountForTest();
        assertFalse(topic.register(account));
        assertFalse(topic.register(null));
    }

    @Test
    public void shouldUnregisterVirtualAccountOnTopic() {
        var topic = new VirtualAccountTopicManager();
        VirtualAccount account = new PrimaryAccount(BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
        topic.register(account);
        assertTrue(topic.unregister(account));
    }

    @Test
    public void shouldNotUnregisterVirtualAccountOnTopic() {
        var topic = new VirtualAccountTopicManager();
        VirtualAccount account = new PrimaryAccount(BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
        assertFalse(topic.unregister(account));

        var accountBase = new AccountForTest();

        assertFalse(topic.unregister(accountBase));
    }

    @Test
    public void shouldUpdateTopic() {
        var topic = new VirtualAccountTopicManager();
        VirtualAccount primary = new PrimaryAccount(BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
        VirtualAccount dependent1 = new DepedentAccount();
        VirtualAccount dependent2 = new DepedentAccount();

        topic.register(primary);
        topic.register(dependent1);
        topic.register(dependent2);

        primary.limit = BigDecimal.ZERO;
        var expectedTrue = topic.updateTopic(primary);

        assertTrue(expectedTrue);
        assertEquals(BigDecimal.ZERO, primary.limit);
        assertEquals(BigDecimal.ZERO, dependent1.limit);
        assertEquals(BigDecimal.ZERO, dependent2.limit);

    }

    @Test
    public void shouldNotUpdateTopic() {
        var topic = new VirtualAccountTopicManager();
        VirtualAccount primary = new PrimaryAccount(BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
        VirtualAccount dependent1 = new DepedentAccount();
        Account account = new AccountForTest();
        topic.register(primary);
        topic.register(dependent1);

        primary.limit = BigDecimal.ZERO;
        var expectedFalse = topic.updateTopic(account);

        assertFalse(expectedFalse);
    }

    @Test
    public void shouldFindFirst(){
        var topic = new VirtualAccountTopicManager();
        VirtualAccount primary = new PrimaryAccount(BigDecimal.valueOf(100), BigDecimal.valueOf(1000));
        VirtualAccount dependent1 = new DepedentAccount();
        topic.register(dependent1);

        var first = topic.first();

        assertNotNull(first);
    }

    @Test
    public void shouldNotFindFirst(){
        var topic = new VirtualAccountTopicManager();

        var first = topic.first();

        assertNull(first);
    }

    class AccountForTest implements Account {

        @Override
        public String update() {
            return null;
        }

        @Override
        public void setAccountTopicManager(AccountTopicManager subject) {

        }
    }

}