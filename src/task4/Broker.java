package task4;

import java.util.List;
import java.util.Random;

public class Broker{
    private final String name;
    private final List<String> stocks;
    private Action action;

    static class Action{
        int amount;
        String stockName;

        Type typeOfAction;
        Action(int amount, String stockName, Type typeOfAction){
            this.amount = amount;
            this.stockName = stockName;
            this.typeOfAction = typeOfAction;
        }
    }

    enum Type{
        BUY,SELL,NONE
    }

    Broker(String name, List<String> stocks) {
        this.name = name;
        this.stocks = stocks;
        randomizeAction();
    }

    public void randomizeAction(){
        Random random = new Random();
        if(random.nextInt(10)>5) {
            action = new Action(random.nextInt(1, 1000), stocks.get(random.nextInt(0, stocks.size())), Type.BUY);
        }
        else{
            action = new Action(random.nextInt(1, 1000), stocks.get(random.nextInt(0, stocks.size())), Type.SELL);
        }
    }
    public String getBrokerName() {
        return name;
    }

    public Action getAction() {
        return action;
    }
}
