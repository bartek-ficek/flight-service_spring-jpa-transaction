package pl.bartekficek.tx.utils;

import org.hibernate.InstantiationException;
import pl.bartekficek.tx.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils {

    private static Map<String, Double> paymentMap = new HashMap<>();

    static {
        paymentMap.put("account1", 12000.0);
        paymentMap.put("account2", 10000.0);
        paymentMap.put("account3", 5000.0);
        paymentMap.put("account4", 8000.0);
    }

    public static boolean validateCreditLimit(String accountNo, double paidAmount) {
        if (paidAmount > paymentMap.get(accountNo)) {
            throw new InsufficientAmountException("Insufficient fund!");
        } else
            return true;
    }
}
