package com.pailabs.wonderland;

import java.util.*;

public class WonderlandCurrencyExchange implements CurrencyExchange {

    private Set<Integer> denominations = new TreeSet<Integer>(Collections.reverseOrder());

    @Override
    public void addBillDenominations(Integer... denominations) {
        this.denominations.addAll(Arrays.asList(denominations));
    }

    @Override
    public Map<Integer, Integer> getBills(long amount) {
        Map<Integer, Integer> billCountMap = new HashMap<>();
        Long balanceAmount = amount;
        for (Integer currentBill : denominations) {
            if (balanceAmount >= currentBill) {
                Integer count = Long.valueOf(balanceAmount / currentBill).intValue();
                if(count > 0) {
                    billCountMap.put(currentBill, count);
                }
                balanceAmount = balanceAmount % currentBill;
            }
        }
        return billCountMap;
    }
}
