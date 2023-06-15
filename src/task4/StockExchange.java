package task4;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class StockExchange extends Thread{
    private final double CRITICAL_INDEX;
    private final ReentrantLock lock = new ReentrantLock();
    private final List<Broker> brokers;
    private final IndexStorage index = new IndexStorage();
    private final Semaphore semaphore = new Semaphore(2);

    public StockExchange(List<Stock> stocks, List<Broker> brokers) {
        CRITICAL_INDEX = 300000;
        for(Stock stock : stocks){
            index.addStock(stock,1000);
        }
        index.countIndex();
        this.brokers = brokers;
        this.start();
    }

    @Override
    public void run() {
        int usedPermits = 0;
        while (true) {
            checkIndex();
            try {
                Broker brokerWhoSells = null;
                Broker brokerWhoBuys = null;
                String stockName = null;
                int amount = 0;
                for(Broker broker : brokers) {
                    if (brokerWhoSells == null && broker.getAction().typeOfAction == Broker.Type.SELL) {
                        semaphore.acquire();
                        stockName = broker.getAction().stockName;
                        amount = broker.getAction().amount;
                        brokerWhoSells = broker;
                        usedPermits += 1;
                        continue;
                    }
                    if (brokerWhoBuys == null && broker.getAction().typeOfAction == Broker.Type.BUY) {
                        semaphore.acquire();
                        brokerWhoBuys = broker;
                        usedPermits += 1;
                        continue;
                    }
                    if(brokerWhoBuys != null && brokerWhoSells != null && brokerWhoSells.getAction().stockName.equals(brokerWhoBuys.getAction().stockName)){
                        exchange(stockName, Math.max(amount, broker.getAction().amount), brokerWhoSells, brokerWhoBuys);
                        usedPermits = 2;
                        brokerWhoBuys.randomizeAction();
                        brokerWhoSells.randomizeAction();
                        continue;
                    }
                    broker.randomizeAction();
                    Thread.sleep(500);
                }
            }
            catch (InterruptedException ignored){

            }
            finally {
                semaphore.release(usedPermits);
                usedPermits = 0;
                Collections.shuffle(brokers);
            }
        }
    }


    public boolean exchange(String stockName, int amount, Broker brokerWhoSells, Broker brokerWhoBuys){
        lock.lock();
        try{
            if (isEnough(amount, stockName) && isExists(stockName)) {
                System.out.println(brokerWhoBuys.getBrokerName()+" is buying "+stockName+" stocks");
                System.out.println(brokerWhoSells.getBrokerName()+" is selling "+stockName+" stocks");
                if(amount > 750){
                    index.findByName(stockName).changePrice(50);
                }
                else{
                    index.findByName(stockName).changePrice(-50);
                }
                index.countIndex();
                checkIndex();
                return true;
            } else {
                System.out.println("Transaction denied");
                return false;
            }
        }
        finally {
            lock.unlock();
        }
    }

    private void checkIndex(){
        if(index.getCurrentIndex() < CRITICAL_INDEX){
            freeze();
        }
    }
    private boolean isEnough(int amountToBuy, String stockName){
        return amountToBuy <= index.getAmountOf(stockName);
    }

    private boolean isExists(String stockName){
        return index.isExists(stockName) != null;
    }

    public void freeze(){
        try{
            lock.lock();
            System.out.println("Trading is suspended");
            index.reset();
            Thread.sleep(2500);
        }
        catch (InterruptedException ignored){
        }
        finally {
            lock.unlock();
        }
    }
}
