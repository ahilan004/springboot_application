package com.example.hackathon.service;

import java.io.IOException;
import java.math.BigDecimal;

import com.example.hackathon.model.StockWrapper;

import yahoofinance.YahooFinance;

public class FinanceService {

	public StockWrapper findStock(final String ticker) {
        try {
            return new StockWrapper(YahooFinance.get(ticker));
        }
        catch (IOException e) {
            System.out.println("Error");
        }
        return null;
    }
 public BigDecimal findPrice(final StockWrapper stock) throws IOException {
        return stock.getStock().getQuote(true).getPrice();
    }

}
