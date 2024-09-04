package com.demo.dev1.stocktrade.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.dev1.stocktrade.model.Trade;

@Repository
public interface TradeRepository extends CrudRepository<Trade, Long> {

  List<Trade> findAllById(Long userId);

  List<Trade> findAllBySymbolAndTypeAndTimestampBetween(String stockSymbol, String typeType, String startDate,
      String endDate);

  List<Trade> findAllBySymbolAndPriceBetween(String stockSymbol, Double price, String startDate, String endDate);

}
