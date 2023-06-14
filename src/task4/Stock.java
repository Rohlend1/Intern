package task4;

import java.util.Objects;

public class Stock{
    private final String companyName;
    private double price;

    Stock(String companyName, double price) {
        this.companyName = companyName;
        this.price = price;
    }

    public String getCompanyName() {
        return companyName;
    }

    public double getPrice() {
        return price;
    }

    public void changePrice(int delta){
        price += delta;
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
