package ru.progwards.java2.lessons.tests.test.app;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.progwards.java2.lessons.tests.app.model.Account;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class TestAccount {

    Account account;

    @Parameterized.Parameter()
    public String id;
    @Parameterized.Parameter(1)
    public String holder;
    @Parameterized.Parameter(2)
    public Date date;
    @Parameterized.Parameter(3)
    public double amount;
    @Parameterized.Parameter(4)
    public int pin;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"132123123", "Mr. Lemon Jeckson", new Date(), 0.0, 1234},
                {"", "", new Date(), 0.0, 0},
                {"ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789 ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789", new Date(), new Random().nextDouble(), new Random().nextInt(Integer.MAX_VALUE)},
                {"132123123", "Mr. Lemon Jeckson", new Date(), Double.MAX_VALUE, Integer.MAX_VALUE},
        });
    }

    @Before
    public void beforeTest(){
        account = new Account();
        account.setId(id);
        account.setAmount(amount);
        account.setHolder(holder);
        account.setDate(date);
        account.setPin(pin);
    }

    @Test
    public void testAccountMethods() {
        assertEquals(id, account.getId());
        assertTrue(account.getAmount() >= 0.0);
        assertEquals(holder, account.getHolder());
        assertEquals(date, account.getDate());
        assertEquals(pin, account.getPin());
    }
}
