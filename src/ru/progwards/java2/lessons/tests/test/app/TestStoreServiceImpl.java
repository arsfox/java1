package ru.progwards.java2.lessons.tests.test.app;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.app.model.Account;
import ru.progwards.java2.lessons.tests.app.service.impl.StoreServiceImpl;

import java.util.Collection;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestStoreServiceImpl {

    private static Collection<Account> accounts;
    private static StoreServiceImpl storeServiceImpl;

    @Before
    public void beforeTest() {
        storeServiceImpl = new StoreServiceImpl();
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

    @Test
    public void testGetAccount() {
        for(Account accExpected : accounts){
            Account acc = storeServiceImpl.get(accExpected.getId());

            assertTrue(acc.getId().equals(accExpected.getId()));
            assertTrue(acc.getHolder().equals(accExpected.getHolder()));

            Double аmount = acc.getAmount();
            assertTrue(аmount.compareTo(acc.getAmount()) == 0);

            assertTrue(acc.getDate().equals(accExpected.getDate()));
            assertTrue(acc.getPin() == accExpected.getPin());
        }
    }

    @Test(expected = RuntimeException.class)
    public void testAccountDelete() {
        Account accDelete = (Account) accounts.toArray()[new Random().nextInt(accounts.size())];
        storeServiceImpl.delete(accDelete.getId());
        storeServiceImpl.get(accDelete.getId());
    }

    @Test(expected = RuntimeException.class)
    public void testAccountInsert() {
        Account accExpected = new Account();

        String id = UUID.randomUUID().toString();
        accExpected.setId(id);

        int pin = new Random().nextInt(1000);
        accExpected.setPin(pin);

        String holder = "Account_"+new Random().nextInt(1000);
        accExpected.setHolder(holder);
        Date date = new Date(System.currentTimeMillis()+365*24*3600*1000);
        accExpected.setDate(date);

        double amount = Math.random()*1_000_000;
        accExpected.setAmount(amount);

        storeServiceImpl.insert(accExpected);
        Account account = storeServiceImpl.get(accExpected.getId());
        assertEquals(account, accExpected);
    }

    @Test(expected = RuntimeException.class)
    public void testUpdateAccountFail() {
        Account accExpected = new Account();
        accExpected.setId(UUID.randomUUID().toString());
        storeServiceImpl.update(accExpected);
    }

    @Test
    public void testUpdateAccount() {
        Account acc = (Account) accounts.toArray()[new Random().nextInt(accounts.size())];
        Account accUpdate = storeServiceImpl.get(acc.getId());

        int pin = new Random().nextInt(1000);
        accUpdate.setPin(pin);

        String holder = "Account_"+new Random().nextInt(1000);
        accUpdate.setHolder(holder);
        Date date = new Date(System.currentTimeMillis()+365*24*3600*1000);
        accUpdate.setDate(date);

        double amount = Math.random()*1_000_000;
        accUpdate.setAmount(amount);

        storeServiceImpl.update(accUpdate);

        Account accAfterUpdate = storeServiceImpl.get(acc.getId());
        assertEquals(accAfterUpdate, accUpdate);
    }

}
