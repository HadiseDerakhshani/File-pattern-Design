package question3;

import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread {
    static Boolean stopThread = false;
    Product product;
    List<Alert> listAlert = new ArrayList<>();
    List<Alert> list = new ArrayList<>();

    public MyThread(Product product, List<Alert> listAlert) {
        this.product = product;
        this.listAlert = listAlert;
    }

    @Override
    public void run() {
        while (true) {
            if (!product.getProductStatus().equals(ProductStatus.UNAVAILABLE)) {
                for (Alert alert : listAlert) {
                    if (!list.contains(alert))
                        alert.alert();
                    list.add(alert);
                }
                if (stopThread) {
                    for (Alert alert : listAlert) {
                        if (!list.contains(alert))
                            alert.alert();
                    }
                    break;
                }
                list = new ArrayList<>();
            }
        }

    }
}
