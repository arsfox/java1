package ru.progwards.java2.lessons.tests.test.app;

import org.junit.Before;
import org.junit.Test;
import ru.progwards.java2.lessons.tests.app.model.Account;
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
        Account accExpected = (Account) storeServiceImpl.get().toArray()[new Random().nextInt(storeServiceImpl.get().size())];
        double summ = Math.random()*1_000_000;
        double summAcc = accExpected.getAmount();

        accountServiceImpl.deposit(accExpected, summ);

        Double amoumtAfterDeposit = accExpected.getAmount();

        assertTrue(amoumtAfterDeposit.compareTo(summ + summAcc) == 0);
    }

    @Test(expected = RuntimeException.class)
    public void testWithdrawExeption() {
        Account accExpected = (Account) storeServiceImpl.get().toArray()[new Random().nextInt(storeServiceImpl.get().size())];
        accountServiceImpl.withdraw(accExpected, Double.MAX_VALUE);
    }

    @Test
    public void testWithdraw() {
        Account accExpected = (Account) storeServiceImpl.get().toArray()[new Random().nextInt(storeServiceImpl.get().size())];
        double summ = Math.random()*1_000_000;
        accExpected.setAmount(summ + summ);
        double summAcc = accExpected.getAmount();

        accountServiceImpl.withdraw(accExpected, summ);

        Double amoumtAfterWithdraw = accExpected.getAmount();

        assertTrue(amoumtAfterWithdraw.compareTo(summAcc - summ) == 0);
    }

    @Test(expected = RuntimeException.class)
    public void testTransferExeption() {
        Account accExpected = (Account) storeServiceImpl.get().toArray()[new Random().nextInt(storeServiceImpl.get().size())];
        Account acc = (Account) storeServiceImpl.get().toArray()[new Random().nextInt(storeServiceImpl.get().size())];
        accountServiceImpl.transfer(accExpected, acc, Double.MAX_VALUE);
    }

    @Test
    public void testTransfer() {
        Double transferSumm = Math.random()*1_000_000;
        Account accExpected = (Account) storeServiceImpl.get().toArray()[new Random().nextInt(storeServiceImpl.get().size())];
        Double summExpected = accExpected.getAmount() + transferSumm;
        Account acc = (Account) storeServiceImpl.get().toArray()[new Random().nextInt(storeServiceImpl.get().size())];
        acc.setAmount(transferSumm);

        accountServiceImpl.transfer(acc, accExpected, transferSumm);

        assertTrue(summExpected.compareTo(accExpected.getAmount()) == 0);
    }

}
