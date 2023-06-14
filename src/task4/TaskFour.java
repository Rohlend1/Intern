package task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TaskFour {
    public static final Stock google = new Stock("Google",129.99);
    public static final Stock amazon = new Stock("Amazon",100.99);
    public static final Stock tesla = new Stock("Tesla",54.97);
    public static final Stock yandex = new Stock("Yandex",99.99);

    public static void main(String[] args) {

        Broker broker1 = new Broker("Tom",new CopyOnWriteArrayList<>(List.of(google.getCompanyName(),amazon.getCompanyName())));
        Broker broker2 = new Broker("John",new CopyOnWriteArrayList<>(List.of(google.getCompanyName(),amazon.getCompanyName())));
        Broker broker3 = new Broker("Bob",new CopyOnWriteArrayList<>(List.of(google.getCompanyName(),amazon.getCompanyName())));
        Broker broker4 = new Broker("Alex",new CopyOnWriteArrayList<>(List.of(google.getCompanyName(),amazon.getCompanyName())));
        StockExchange stockExchange = new StockExchange(new CopyOnWriteArrayList<>(List.of(google,amazon,tesla,yandex)),
                new ArrayList<>(List.of(broker1,broker2,broker3,broker4)));
    }
}



