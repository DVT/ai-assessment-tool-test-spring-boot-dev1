package com.demo.dev1.stocktrade.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dev1.stocktrade.model.Trade;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {

  @DeleteMapping(path = "", produces = "application/json")
  public ResponseEntity<Trade> eraseAllTrades() {
    return new ResponseEntity<Trade>(HttpStatus.OK);
  }
}
