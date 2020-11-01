package com.codecool.stocktrader;

import com.codecool.stocktrader.service.RemoteURLReader;
import com.codecool.stocktrader.service.StockAPIService;
import com.codecool.stocktrader.service.Trader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class StockTraderApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockTraderApplication.class, args);
    }
}
