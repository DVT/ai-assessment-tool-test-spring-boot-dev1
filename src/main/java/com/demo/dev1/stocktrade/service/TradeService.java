package com.demo.dev1.stocktrade.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dev1.stocktrade.model.Trade;
import com.demo.dev1.stocktrade.repository.TradeRepository;

@Service
public class TradeService {

  @Autowired
  private static TradeRepository tradeRepository;

	public static Trade getTradeById(Long tradeId) {
		return tradeRepository.findById(tradeId).orElse(null);
	}

  public static Trade createTrade(Trade trade) {
    return tradeRepository.save(trade);
  }

  public static List<Trade> getAllTrades() {
    return (List<Trade>) tradeRepository.findAll();
  }

  public static List<Trade> getAllTradesByUserId(Long userId) {
    return (List<Trade>) tradeRepository.findAllById(userId);
  }

  public static List<Trade> getAllTradesByStockSymbolAndDateRange(String stockSymbol, String typeType, String startDate,
      String endDate) {

    return (List<Trade>) tradeRepository.findAllBySymbolAndTypeAndTimestampBetween(stockSymbol, typeType, startDate, endDate);
  }

  public static List<Trade> getAllTradesByStockSymbolAndPriceRange(String stockSymbol, Double price, String startDate,
      String endDate) {


    return tradeRepository.findAllBySymbolAndPriceBetween(stockSymbol, price, startDate, endDate);
  }

}
