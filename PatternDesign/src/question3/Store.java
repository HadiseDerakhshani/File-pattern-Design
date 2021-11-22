package question3;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private Product product;
    private List<Alert> listAlert = new ArrayList<>();

    public Store(Product product) {
        this.product = product;
    }

    public void addListAlert(Alert alert) {
        listAlert.add(alert);
    }

    public void removeListAlert(Alert alert) {
        listAlert.remove(0);
    }

    public void active() {
        Thread thread = new Thread(() -> {
            while (true) {
                if (!product.getProductStatus().equals(ProductStatus.UNAVAILABLE)) {
                    for (Alert alert : listAlert) {
                        alert.alert();
                    }
                    listAlert = new ArrayList<>();
                }
            }
        });
        thread.start();

    }
}
