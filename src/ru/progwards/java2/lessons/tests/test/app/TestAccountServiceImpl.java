package ru.progwards.java2.lessons.tests.test.app;

import org.junit.Before;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.app.model.Account;
import ru.progwards.java2.lessons.tests.app.service.StoreService;
import ru.progwards.java2.lessons.tests.app.service.impl.AccountServiceImpl;
import ru.progwards.java2.lessons.tests.app.service.impl.StoreServiceImpl;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class TestAccountServiceImpl {

    AccountServiceImpl accountServiceImpl;
    StoreServiceImpl storeServiceImpl;

    @Before
    public void beforeTest() {
        storeServiceImpl = new StoreServiceImpl();
        accountServiceImpl = new AccountServiceImpl(storeServiceImpl);
    }

    @Test
    public void testGetBalance() {
        Account acc = (Account) storeServiceImpl.get().toArray()[new Random().nextInt(storeServiceImpl.get().size())];
        Double balance = accountServiceImpl.balance(acc);
        assertTrue(balance.compareTo(acc.getAmount()) == 0);
    }

    @Test
    public void testDeposit() {
        Account acc = (Account) storeServiceImpl.get().toArray()[new Random().nextInt(storeServiceImpl.get().size())];
        accountServiceImpl.deposit(acc, Math.random()*1_000_000);
        assertTrue(storeServiceImpl.get(acc.getId()).getAmount() );

    }

}
