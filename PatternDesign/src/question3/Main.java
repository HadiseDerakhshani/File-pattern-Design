package question3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product product = new Product("BAG", 20000, 3);
        List<Alert> listAlert = product.getStore().getListAlert();

        MyThread thread = new MyThread(product, listAlert);
        thread.start();
        Hadiseh hadiseh = new Hadiseh();
        product.getStore().addListAlert(hadiseh);
        product.offPrice(0.02);
        Sama sama = new Sama();
        product.getStore().addListAlert(sama);
        product.addCount(5);
        MyThread.stopThread = true;
    }
}
