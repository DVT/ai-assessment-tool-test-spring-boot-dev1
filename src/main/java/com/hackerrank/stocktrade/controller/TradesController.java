package com.hackerrank.stocktrade.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.service.TradeService;
import com.hackerrank.stocktrade.service.UserService;

@RestController
@RequestMapping(value = "/trades")
public class TradesController {

  @PostMapping(path = "", produces = "application/json")
  public ResponseEntity<Trade> createTrade(@RequestBody Trade trade) {

    Trade createdTrade = TradeService.createTrade(trade);

    if (TradeService.getTradeById(createdTrade.getId()) != null) {
      return new ResponseEntity<Trade>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<Trade>(trade, HttpStatus.CREATED);
  }

  @GetMapping(path = "/{id}}", produces = "application/json")
  public ResponseEntity<Trade> getTradeById(@PathVariable Long id) {

    Trade foundTrade = TradeService.getTradeById(id);
    if (foundTrade == null) {
      return new ResponseEntity<Trade>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Trade>(foundTrade, HttpStatus.OK);
  }

  @GetMapping(path = "/", produces = "application/json")
  public ResponseEntity<List<Trade>> getAllTrades() {
    List<Trade> trades = TradeService.getAllTrades();
    return new ResponseEntity<List<Trade>>(trades, HttpStatus.OK);
  }

  @GetMapping(path = "/users/{userId}", produces = "application/json")
  public ResponseEntity<List<Trade>> getAllTradesByUserId(@PathVariable Long userId) {
    List<Trade> trades = TradeService.getAllTradesByUserId(userId);
    return new ResponseEntity<List<Trade>>(trades, HttpStatus.OK);
  }

  @GetMapping(path = "/stocks/{stockSymbol}?type={typeType}&start={startDate}&end={endDate}", produces = "application/json")
  public ResponseEntity<List<Trade>> getAllTradesByStockSymbolAndDateRange(@PathVariable String stockSymbol, @PathVariable String typeType, @PathVariable String startDate, @PathVariable String endDate) {

    List<Trade> trades = TradeService.getAllTradesByStockSymbolAndDateRange(stockSymbol, typeType, startDate, endDate);

    if (trades == null) {
      return new ResponseEntity<List<Trade>>(HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<List<Trade>>(trades, HttpStatus.OK);

  }

  @GetMapping(path = "/stocks/{stockSymbol}/price?&start={startDate}&end={endDate}", produces = "application/json")
  public ResponseEntity<List<Trade>> getAllTradesByStockSymbolAndPriceRange(@PathVariable String stockSymbol, @PathVariable Double price, @PathVariable String startDate, @PathVariable String endDate) {


    List<Trade> trades = TradeService.getAllTradesByStockSymbolAndPriceRange(stockSymbol, price, startDate, endDate);

    if (trades == null) {

      return new ResponseEntity<List<Trade>>(HttpStatus.NOT_FOUND);

    }

    return new ResponseEntity<List<Trade>>(trades, HttpStatus.OK);
  }

}
