package question3;

import lombok.Data;

@Data
public class Product {
    private String pName;
    private double price;
    private int number;
    private ProductStatus productStatus;
    private Store store;


    public Product(String pName, double price, int number) {
        this.pName = pName;
        this.price = price;
        this.number = number;
        setProductStatus(ProductStatus.AVAILABLE);
        store = new Store(this);
    }

    public void offPrice(double amount) {
        this.price = this.price - (this.price * amount);
        this.setProductStatus(ProductStatus.DISCOUNT);
    }

    public void addCount(int count) {
        this.number += count;
    }
}
