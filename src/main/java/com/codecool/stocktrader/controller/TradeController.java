package com.codecool.stocktrader.controller;

import com.codecool.stocktrader.service.RemoteURLReader;
import com.codecool.stocktrader.service.StockAPIService;
import com.codecool.stocktrader.service.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class TradeController {

    @Autowired
    private final RemoteURLReader remoteURLReader = new RemoteURLReader();
    @Autowired
    private final StockAPIService stockAPIService = new StockAPIService(remoteURLReader);
    @Autowired
    private final Trader trader = new Trader(stockAPIService);

    @GetMapping("/buy/{stock}/{price}")
    public String buyStock(@PathVariable("stock") String stock, @PathVariable("price") int price) throws IOException {
        if(trader.buy(stock,price)){
            return "Bought " + stock + " stock for " + price;
        }
        return "Couldn't buy " + stock + " stock for " + price;
    }


}
