package designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.account;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.util.NotificationObserver;

public class MerchantAccount extends WalletAccount implements NotificationObserver {
    public MerchantAccount(String id, String name, double balance) {
        super(id, name, balance);
    }

    @Override
    public void notify(String message) {
        System.out.println("[Merchant Notification] " + getName() + ": " + message);
    }
}
