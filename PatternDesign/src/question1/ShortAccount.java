package question1;

public class ShortAccount implements Account {
    private final static int balance = 50000;

    @Override
    public void creatAccount(Customer customer) {
        if (customer.getBalance() >= balance) {
            String print = String.format(" creat a new short account for %s  %s  ", customer.getCName(), customer.getCFamily());
            System.out.println(print);
            profit(customer);
        }
    }

    public void profit(Customer customer) {
        String print = String.format(" amount  %d profit every months add to balance ", (int) (customer.getBalance() + (customer.getBalance() * 0.07)));
        System.out.println(print);
    }
}
