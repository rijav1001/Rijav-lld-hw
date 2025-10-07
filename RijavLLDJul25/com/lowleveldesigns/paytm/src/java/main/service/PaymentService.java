package designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.service;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.account.*;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.util.NotificationService;

public class PaymentService {
    private final WalletService walletService;
    private final NotificationService notifier;

    public PaymentService(WalletService walletService, NotificationService notifier) {
        this.walletService = walletService;
        this.notifier = notifier;
    }

    public synchronized void transfer(UserAccount user, MerchantAccount merchant, double amount) {
        boolean success = false;

        if (walletService.withdraw(user, amount)) {
            walletService.deposit(merchant, amount);
            success = true;
        }

        if (success) {
            notifier.notifyAllObservers(
                    "Payment of " + amount + " from " + user.getName() + " to " + merchant.getName()
            );
        } else {
            notifier.notifyAllObservers(
                    "Payment failed: insufficient balance in " + user.getName() + "'s account."
            );
        }
    }
}
