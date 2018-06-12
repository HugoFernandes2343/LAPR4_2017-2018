package pt.isep.nsheets.server.lapr4.red.s2.ipc.s1161569.domain;

import org.junit.Test;

import java.util.Date;

public class MessageTest {

    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowedOnMessageUsername() {
        System.out.println("ensureNullIsNotAllowedOnMessage");
        Message instance = new Message(null,"this is a test message", new Date());
    }
    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowedOnMessageText() {
        System.out.println("ensureNullIsNotAllowedOnMessage");
        Message instance = new Message("s1161569",null, new Date());
    }
    @Test(expected = IllegalArgumentException.class)
    public void ensureNullIsNotAllowedOnMessageDate() {
        System.out.println("ensureNullIsNotAllowedOnMessage");
        Message instance = new Message("s1161569","this is a test message", null);
    }

}