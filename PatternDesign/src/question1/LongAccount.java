package question1;

public class LongAccount implements Account {
    private final static int balance = 100000;

    @Override
    public void creatAccount(Customer customer) {
        if (customer.getBalance() >= balance) {
            String print = String.format(" creat a new Long account for %s  %s  ", customer.getCName(), customer.getCFamily());
            System.out.println(print);
        }
    }

}
