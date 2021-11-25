package question3;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Store {
    private Product product;
    private List<Alert> listAlert = new ArrayList<>();

    public Store(Product product) {
        this.product = product;
    }

    public synchronized void addListAlert(Alert alert) {
        listAlert.add(alert);
    }

    public void removeListAlert(Alert alert) {
        listAlert.remove(0);
    }

    public void active() {

       /* Thread thread = new Thread(() -> {
            while (true) {
                if (!product.getProductStatus().equals(ProductStatus.UNAVAILABLE)) {
                    for (Alert alert : listAlert) {
                        alert.alert();
                    }
                    listAlert = new ArrayList<>();
                  //  break;
                }
            }
        });
        thread.setDaemon(true);
        thread.start();*/

    }
}
    /*Thread thread = new Thread(() -> {
        while (true) {
            if (!product.getProductStatus().equals(ProductStatus.UNAVAILABLE)) {
                for (Alert alert : listAlert) {
                    alert.alert();
                }
                listAlert = new ArrayList<>();
                //  break;
            }
        }
    });
        thread.setDaemon(true);
                thread.start();*/