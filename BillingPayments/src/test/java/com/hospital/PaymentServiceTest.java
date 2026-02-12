package BillingPayments.src.test.java.com.hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BillingPayments.src.main.java.com.hospital.BillingService;
import BillingPayments.src.main.java.com.hospital.PaymentService;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentServiceTest {

    private BillingService billingService;
    private PaymentService paymentService;

    @BeforeEach
    void setup() {
        billingService = new BillingService();
        paymentService = new PaymentService(billingService);
    }

    @Test
    void testSuccessfulPayment() {
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);

        paymentService.processPayment("P101", 500);

        assertTrue(billingService.getBill("P101").isPaid());
    }

    @Test
    void testInsufficientPayment() {
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);

        assertThrows(IllegalArgumentException.class, () -> {
            paymentService.processPayment("P101", 300);
        });
    }

    @Test
    void testBillAlreadyPaid() {
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);

        paymentService.processPayment("P101", 500);

        assertThrows(IllegalStateException.class, () -> {
            paymentService.processPayment("P101", 500);
        });
    }

    @Test
    void testPaymentBillNotFound() {
        assertThrows(RuntimeException.class, () -> {
            paymentService.processPayment("P999", 500);
        });
    }
}
