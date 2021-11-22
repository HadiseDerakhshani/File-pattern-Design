package question1;

public class CurrentAccount implements Account {
    private final static int balance = 100000;

    @Override
    public void creatAccount(Customer customer) {
        if (customer.getBalance() >= balance) {
            String print = String.format(" creat a new current account for %s  %s  ", customer.getCName(), customer.getCFamily());
            System.out.println(print);
            getCheck(customer);
        }
    }

    public void getCheck(Customer customer) {
        String print = String.format("check is created for %s %s ", customer.getCName(), customer.getCFamily());
        System.out.println(print);
    }
}
