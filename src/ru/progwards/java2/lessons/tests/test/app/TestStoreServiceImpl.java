package ru.progwards.java2.lessons.tests.test.app;

import org.junit.BeforeClass;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.app.model.Account;
import ru.progwards.java2.lessons.tests.app.service.impl.StoreServiceImpl;

import java.util.Collection;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStoreServiceImpl {

    private static Collection<Account> accounts;

    @BeforeClass
    public static void before() {
        StoreServiceImpl storeServiceImpl = new StoreServiceImpl();
        accounts = storeServiceImpl.get();
    }

    @Test
    public void testGetAccountCount() {
        assertTrue(accounts.size() > 0);
    }

    @Test
    public void testAccountGet() {
        for(Account acc : accounts) {
            assertTrue(acc.getId().length() > 0);
            assertTrue(acc.getHolder().length() > 0);
            assertTrue(acc.getAmount() >= 0.0);
            assertTrue(acc.getDate() instanceof Date);
            assertTrue(acc.getPin() >= 1000);
        }
    }
}
