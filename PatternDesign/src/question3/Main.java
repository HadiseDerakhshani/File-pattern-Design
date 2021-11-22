package question3;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("BAG", 20000, 3);
        Hadiseh hadiseh = new Hadiseh();
        product.getStore().addListAlert(hadiseh);
        product.offPrice(0.02);
        Sama sama = new Sama();
        product.getStore().addListAlert(sama);
        product.getStore().addListAlert(sama);
        product.addCount(5);
    }
}
