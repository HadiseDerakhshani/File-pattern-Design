package question1;

import lombok.Data;

@Data
public class Customer {
    private String cName;
    private String cFamily;
    private AccountType accountType;
    private int balance;

    public Customer(String cName, String cFamily, AccountType accountType, int balance) {
        this.cName = cName;
        this.cFamily = cFamily;
        this.accountType = accountType;
        this.balance = balance;
    }
}
