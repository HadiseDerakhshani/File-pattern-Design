package question3;

public enum ProductStatus {
    AVAILABLE("Available"), UNAVAILABLE("Unavailable"), DISCOUNT("Discount");
    String status;

    ProductStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
