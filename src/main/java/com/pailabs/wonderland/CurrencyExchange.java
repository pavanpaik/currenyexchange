package com.pailabs.wonderland;

import java.util.Map;

public interface CurrencyExchange {

    void addBillDenominations(Integer... denominations);

    Map<Integer, Integer> getBills(long amount);
}
