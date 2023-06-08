package task4;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Stock{
    private final String companyName;
    private double price;
    private final double DELTA_PRICE = 0.1d;
    private final AtomicInteger amount = new AtomicInteger(1000);

    Stock(String companyName, double price) {
        this.companyName = companyName;
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double countFullPrice(){
        return price*amount.get();
    }

    public AtomicInteger getAmount() {
        return amount;
    }
    public void buy(int amountToBuy){
        amount.addAndGet(-amountToBuy);
        price += amountToBuy*DELTA_PRICE;
    }
    public void sell(int amountToBuy){
        amount.addAndGet(amountToBuy);
        price -= amountToBuy*DELTA_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Stock stock = (Stock) o;

        return Objects.equals(companyName, stock.companyName);
    }

    @Override
    public int hashCode() {
        return companyName != null ? companyName.hashCode() : 0;
    }
}
