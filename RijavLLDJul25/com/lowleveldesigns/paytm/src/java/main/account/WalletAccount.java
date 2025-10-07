package designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.account;

public abstract class WalletAccount {
    private final String id;
    private final String name;
    private double balance;

    public WalletAccount(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public String getId() { return id; }
    public String getName() { return name; }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }

    @Override
    public String toString() {
        return name + " (id=" + id + ", balance=" + balance + ")";
    }
}
