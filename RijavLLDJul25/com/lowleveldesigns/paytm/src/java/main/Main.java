package designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main;

import designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.account.*;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.service.PaymentService;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.service.WalletService;
import designpatterns.RijavLLDJul25.com.lowleveldesigns.paytm.src.java.main.util.NotificationService;

public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        WalletService walletService = new WalletService();
        PaymentService paymentService = new PaymentService(walletService, notificationService);

        UserAccount user = new UserAccount("u1", "Alice", 1000.0);
        MerchantAccount merchant = new MerchantAccount("m1", "ShopMart", 500.0);

        // register observers
        notificationService.registerObserver(user);
        notificationService.registerObserver(merchant);

        System.out.println("Initial Balances:");
        System.out.println(user);
        System.out.println(merchant);

        paymentService.transfer(user, merchant, 200.0);

        System.out.println("Balances after transfer:");
        System.out.println(user);
        System.out.println(merchant);
    }
}
