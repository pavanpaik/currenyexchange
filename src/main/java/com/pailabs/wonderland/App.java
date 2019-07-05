package com.pailabs.wonderland;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer datasetCount = Integer.parseInt(reader.readLine());
        List<String> datasets = new ArrayList();
        for (int i = 0; i < datasetCount; i++) {
            datasets.add(reader.readLine());
        }

        for (String dataset : datasets) {
            String result = parseDatasetAndExecute(dataset);
            System.out.println(result);
        }
    }

    public static String parseDatasetAndExecute(String dataset) {
        String[] temp = dataset.split("\\s+");
        Long amount = Long.parseLong(temp[0]);
        Integer[] bills = new Integer[temp.length-1];
        for (int i = 0; i < temp.length-1; i++) {
            bills[i] = Integer.parseInt(temp[i+1]);
        }
        return execute(amount, bills);
    }

    private static String execute(Long amount, Integer... bills) {
        CurrencyExchange exchange = new WonderlandCurrencyExchange();
        exchange.addBillDenominations(bills);
        return getBillCountOrError(amount, exchange);
    }

    static String getBillCountOrError(Long amount, CurrencyExchange exchange) {
        Integer totalAmount = 0;
        Map<Integer, Integer> bills = exchange.getBills(amount);
        for (Map.Entry<Integer, Integer> entry : bills.entrySet()) {
            totalAmount += entry.getKey() * entry.getValue();
        }

        if (totalAmount < amount) {
            return "error";
        } else {
            return String.valueOf(bills.size());
        }
    }
}
