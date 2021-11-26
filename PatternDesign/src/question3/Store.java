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

}
