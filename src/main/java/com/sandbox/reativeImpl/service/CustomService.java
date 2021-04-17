package com.sandbox.reativeImpl.service;

import com.sandbox.reativeImpl.model.HandlerFunction;
import com.sandbox.reativeImpl.model.Stocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class CustomService {

  Logger logger = LoggerFactory.getLogger(CustomService.class);

  List<Stocks> list = new CopyOnWriteArrayList<>();
  public HandlerFunction<ServerResponse> handler;
  Random price = new Random();

  public CustomService() {
    buildStocks();
  }

  public void buildStocks() {
    list = new CopyOnWriteArrayList<>();
    list.add(
        new Stocks(
            "TSLA",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NYSE",
            "AUTO"));
    list.add(
        new Stocks(
            "BOA",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NYSE",
            "BANKS"));
    list.add(
        new Stocks(
            "AAPL",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NYSE",
            "CONSUMER"));
    list.add(
        new Stocks(
            "SBUX",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NYSE",
            "CONSUMER"));
    list.add(
        new Stocks(
            "UBER",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NYSE",
            "AUTO"));
    list.add(
        new Stocks(
            "LYFT",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NYSE",
            "AUTO"));
    list.add(
        new Stocks(
            "GOOGLE",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "CONSUMER"));
    list.add(
        new Stocks(
            "AMAZON",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "CONSUMER"));
    list.add(
        new Stocks(
            "NETFLIX",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "WF",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).boxed().limit(1).findFirst().get(),
            "NYSE",
            "BANKS"));
    list.add(
        new Stocks(
            "HBO",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).boxed().limit(1).findFirst().get(),
            "NYSE",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "PRIME VIDEO",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "BLNK",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "CONSUMER"));
    list.add(
        new Stocks(
            "VISL",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "PEPSI",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).boxed().limit(1).findFirst().get(),
            "NYSE",
            "BANKS"));
    list.add(
        new Stocks(
            "FORD",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).boxed().limit(1).findFirst().get(),
            "NYSE",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "CHEWY",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "ABCP",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).boxed().limit(1).findFirst().get(),
            "NYSE",
            "BANKS"));
    list.add(
        new Stocks(
            "ABT",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).boxed().limit(1).findFirst().get(),
            "NYSE",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "ACAM",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "AGO",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "CONSUMER"));
    list.add(
        new Stocks(
            "BBY",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "TONY",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).boxed().limit(1).findFirst().get(),
            "NYSE",
            "BANKS"));
    list.add(
        new Stocks(
            "BCEL",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).boxed().limit(1).findFirst().get(),
            "NYSE",
            "ENTERTAINMENT"));
    list.add(
        new Stocks(
            "BMRC",
            Math.round(price.doubles(50.00, 999.99).limit(1).boxed().findFirst().get()),
            price.ints(50, 999).limit(1).boxed().findFirst().get(),
            "NASDAQ",
            "ENTERTAINMENT"));
  }

  public List<Stocks> getStocks() {

    return list;
  }

  public Stocks getStockData(String stockSymbol) {
    return list.stream().filter(r -> r.getSymbol().equalsIgnoreCase(stockSymbol)).findFirst().get();
  }
}
