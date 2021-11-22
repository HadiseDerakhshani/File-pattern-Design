package question1;

public class Main {
    public static void main(String[] args) {
        Customer ali = new Customer("Ali", "Hoseini", AccountType.SHORT, 150000);
        Account aliAccount = Account.factory(ali.getAccountType());
        aliAccount.creatAccount(ali);
        Customer mohammad = new Customer("Mohammad", "Mohammadi", AccountType.CURRENT, 2000000);
        Account mohammadAccount = Account.factory(mohammad.getAccountType());
        mohammadAccount.creatAccount(mohammad);
    }
}
