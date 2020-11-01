package com.codecool.stocktrader.service;

import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Trader {
    private final StockAPIService stockService;

    public Trader(StockAPIService stockAPIService) {
        this.stockService = stockAPIService;
    }

    /**
     * Checks the price of a stock, and buys it if the price is not greater than the bid amount.
     *
     * @return whether any stock was bought
     */
    public boolean buy(String symbol, double bid) throws IOException {
        double price = stockService.getPrice(symbol);

        boolean result;
        if (price <= bid) {
            result = true;
            stockService.buy(symbol);
        } else {
            result = false;
        }
        return result;
    }
}
