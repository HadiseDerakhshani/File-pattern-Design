package question3;

import lombok.Data;

@Data
public class Product {
    private String pName;
    private double price;
    private int number;
    private ProductStatus productStatus;
    private Store store;

   /* public Product() {
       setProductStatus(ProductStatus.AVAILABLE);
       store= new Store(this);
       store.active();
    }*/

    public Product(String pName, double price, int number) {
        this.pName = pName;
        this.price = price;
        this.number = number;
        setProductStatus(ProductStatus.AVAILABLE);
        store = new Store(this);
        store.active();
    }

    public void offPrice(double amount) {//method for discount ,darsad of discount is entered parameter;

        this.price = this.price - (this.price * amount);
        this.setProductStatus(ProductStatus.DISCOUNT);
    }

    public void addCount(int count) {
        this.number += count;
    }
}
