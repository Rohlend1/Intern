package task4;

import java.util.ArrayList;
import java.util.List;

public class TaskFour {
    public static final Stock google = new Stock("Google",129.99);
    public static final Stock amazon = new Stock("Amazon",100.99);

    public static void main(String[] args) {
        StockExchange stockExchange = new StockExchange(new ArrayList<>(List.of(google,amazon)));
        Broker broker1 = new Broker("Tom",stockExchange);
        Broker broker2 = new Broker("John",stockExchange);
        Broker broker3 = new Broker("Bob",stockExchange);
        Broker broker4 = new Broker("Alex",stockExchange);
    }
}



