package BillingPayments.src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BillingPayments.src.main.BillingService;
import BillingPayments.src.main.PaymentService;

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
    void testSuccessfullPayment() {
        System.out.println("Running testSuccessfullPayment");
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);
        System.out.println("Created bill P101 with total: " + billingService.getTotal("P101"));

        paymentService.processPayment("P101", 500);
        System.out.println("Processed payment of 500 for P101");

        assertTrue(billingService.getBill("P101").isPaid());
    }

    @Test
    void testInsufficientPayment() {
        System.out.println("Running testInsufficientPayment");
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);
        System.out.println("Attempting insufficient payment of 300 for P101 (expect IllegalArgumentException)");

        assertThrows(IllegalArgumentException.class, () -> {
            paymentService.processPayment("P101", 300);
        });
    }

    @Test
    void testBillAlreadyPaid() {
        System.out.println("Running testBillAlreadyPaid");
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);

        paymentService.processPayment("P101", 500);
        System.out.println("First payment processed for P101");

        System.out.println("Attempting second payment for already paid bill P101 (expect IllegalStateException)");
        assertThrows(IllegalStateException.class, () -> {
            paymentService.processPayment("P101", 500);
        });
    }

    @Test
    void testPaymentBillNotFound() {
        System.out.println("Running testPaymentBillNotFound");
        System.out.println("Attempting payment for non-existing bill P999 (expect RuntimeException)");
        assertThrows(RuntimeException.class, () -> {
            paymentService.processPayment("P999", 500);
        });
    }
}














