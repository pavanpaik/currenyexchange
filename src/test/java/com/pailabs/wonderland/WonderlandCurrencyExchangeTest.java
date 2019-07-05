package com.pailabs.wonderland;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class WonderlandCurrencyExchangeTest {

    @Test
    public void getBills() {
        WonderlandCurrencyExchange exchange = new WonderlandCurrencyExchange();
        exchange.addBillDenominations(5, 10, 20, 50, 100);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(100, 1);
        expected.put(50, 1);
        assertEquals(expected, exchange.getBills(150));


        expected = new HashMap<>();
        expected.put(100, 2);
        expected.put(50, 1);
        assertEquals(expected, exchange.getBills(250));

        expected = new HashMap<>();
        expected.put(100, 3);
        assertEquals(expected, exchange.getBills(300));

        expected = new HashMap<>();
        expected.put(100, 3);
        assertEquals(expected, exchange.getBills(301));

        expected = new HashMap<>();
        expected.put(100, 3);
        expected.put(50, 1);
        expected.put(20, 2);
        expected.put(5, 1);
        assertEquals(expected, exchange.getBills(399));


        expected = new HashMap<>();
        expected.put(100, 3);
        expected.put(50, 1);
        expected.put(20, 2);
        expected.put(5, 1);
        assertEquals(expected, exchange.getBills(395));

        expected = new HashMap<>();
        expected.put(100, 3);
        expected.put(50, 1);
        expected.put(20, 2);
        //expected.put(5,1);
        assertEquals(expected, exchange.getBills(394));
    }

    @Test
    public void getBillsBig() {
        WonderlandCurrencyExchange exchange = new WonderlandCurrencyExchange();
        exchange.addBillDenominations(1, 5, 10, 20, 50, 100, 500, 1000);

        Map<Integer, Integer> expected = new HashMap<>();
        expected.put(1000, 4_000_000);
        assertEquals(expected, exchange.getBills(4_000_000_000l));


        expected = new HashMap<>();
        expected.put(1000, 4_000_000);
        expected.put(1, 1);
        assertEquals(expected, exchange.getBills(4_000_000_001l));


        expected = new HashMap<>();
        expected.put(1000, 4_000_000);
        expected.put(5, 1);
        assertEquals(expected, exchange.getBills(4_000_000_005l));

        expected = new HashMap<>();
        expected.put(1000, 4_000_000);
        expected.put(5, 1);
        expected.put(1, 1);
        assertEquals(expected, exchange.getBills(4_000_000_006l));

    }
}
