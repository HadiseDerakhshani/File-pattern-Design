package question1;

public interface Account {

    static Account factory(AccountType accountType) {
        Account account;
        switch (accountType) {
            case LONG -> account = new LongAccount();
            case SHORT -> account = new ShortAccount();
            case CURRENT -> account = new CurrentAccount();
            default -> account = new LongAccount();
        }
        return account;
    }

    void creatAccount(Customer customer);
}
