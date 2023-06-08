package task4;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Broker extends Thread{
    private final String name;
    private final ConcurrentHashMap<Stock,Integer> stocks = new ConcurrentHashMap<>();
    private final StockExchange stockExchange;
    Broker(String name, StockExchange stockExchange) {
        this.name = name;
        this.stockExchange = stockExchange;
        this.start();
    }

    @Override
    public void run() {
        Random random = new Random();
        while(true){
            if(random.nextInt(0,10) < 5){
                stockExchange.sell(random.nextInt(0,1000),
                        stockExchange.getStocks().get(random.nextInt(stockExchange.getStocks().size())),this);
            }
            else{
                stockExchange.buy(random.nextInt(0,1000),
                        stockExchange.getStocks().get(random.nextInt(stockExchange.getStocks().size())),this);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void addStockToPortfolio(Stock stock, int amount){
        stocks.put(stock,amount);
    }
    public void sellStockFromPortfolio(Stock stock, int amount){
        stocks.put(stock,stocks.get(stock)-amount);
    }
    public boolean hasEnough(int amount, Stock stock){
        return stocks.getOrDefault(stock,0) >= amount;
    }

    public String getBrokerName() {
        return name;
    }
}
