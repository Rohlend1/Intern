package task4;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class IndexStorage {
    private final double START_INDEX = 330000;
    private double currentIndex;
    private final List<Stock> stocks = new CopyOnWriteArrayList<>();
    private final Map<String, Integer> amountOfStocks = new ConcurrentHashMap<>();

    public IndexStorage() {

    }

    public void countIndex(){
       currentIndex = stocks.stream().mapToDouble(s-> s.getPrice()*amountOfStocks.get(s.getCompanyName())).sum();
    }

    public double getCurrentIndex() {
        return currentIndex;
    }

    public void addStock(Stock stock, int amount){
        stocks.add(stock);
        amountOfStocks.put(stock.getCompanyName(),amount);
    }

    public Stock isExists(String stockName){
        return stocks.stream().filter(s->s.getCompanyName().equals(stockName)).findAny().orElseThrow();
    }

    public int getAmountOf(String stockName){
        return amountOfStocks.get(stockName);
    }

    public void reset(){
        currentIndex = START_INDEX;
    }

    public Stock findByName(String stockName){
        return stocks.stream().filter(s->s.getCompanyName().equals(stockName)).findAny().get();
    }
}
