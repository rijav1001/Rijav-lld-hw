package designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.service;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.account.WalletAccount;

public class WalletService {
    public synchronized double getBalance(WalletAccount account) {
        return account.getBalance();
    }

    public synchronized void deposit(WalletAccount account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    public synchronized boolean withdraw(WalletAccount account, double amount) {
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return true;
        }
        return false;
    }
}
