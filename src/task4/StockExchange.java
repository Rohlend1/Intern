package task4;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class StockExchange extends Thread{
    private double index;
    private final double START_INDEX;
    private final ReentrantLock lock = new ReentrantLock();

    private final List<Stock> stocks;
    public StockExchange(List<Stock> stocks) {
        this.stocks = stocks;
        countIndex();
        START_INDEX = this.index;
        this.start();
    }

    @Override
    public void run() {
        while (true) {
            if (index < 0.0) {
                freeze();
            }
        }
    }

    public boolean buy(int amount, Stock stock, Broker broker){
        lock.lock();
        try {
            Stock stockToBuy = isExists(stock);
            if (isEnough(amount, stockToBuy)) {
                System.out.println(broker.getBrokerName()+" is buying "+stockToBuy.getCompanyName()+" stocks");
                stockToBuy.buy(amount);
                broker.addStockToPortfolio(stockToBuy, amount);
                countIndex();
                checkIndex();
                return true;
            } else {
                return false;
            }
        }
        finally {
            lock.unlock();
        }
    }
    public boolean sell(int amount, Stock stock, Broker broker){
        lock.lock();
        try {
            Stock stockToSell = isExists(stock);
            if(broker.hasEnough(amount,stockToSell)){
                System.out.println(broker.getBrokerName()+" is selling "+stockToSell.getCompanyName()+" stocks");
                stockToSell.sell(amount);
                broker.sellStockFromPortfolio(stockToSell,amount);
                countIndex();
                checkIndex();
                return true;
            }
            else{
                return false;
            }
        }
        finally {
            lock.unlock();
        }
    }
    private void countIndex(){
        this.index = stocks.stream().mapToDouble(Stock::countFullPrice).sum()/1000;
    }

    private void checkIndex(){
        if(START_INDEX/index > 2){
            freeze();
        }
    }
    private boolean isEnough(int amountToBuy, Stock stock){
        return amountToBuy <= stock.getAmount().get();
    }

    private Stock isExists(Stock stock){
        return stocks.stream().filter(s->s.getCompanyName().equals(stock.getCompanyName())).findAny().orElseThrow();
    }


    public void freeze(){
        try{
            lock.lock();
            System.out.println("Trading is suspended");
            index += index/2;
            Thread.sleep(1000);
        }
        catch (InterruptedException ignored){

        }
        finally {
            lock.unlock();
        }
    }

    public List<Stock> getStocks() {
        return stocks;
    }
}
