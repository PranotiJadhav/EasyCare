package billingpayments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {

    private Payment payment;

    @BeforeEach
    void setUp() {
        System.out.println("DEBUG: Creating Payment object...");
        payment = new Payment("INV123", 1000);
    }

    @Test
    void testInitialStatusIsPending() {
        System.out.println("DEBUG: Checking initial payment status...");
        assertEquals("PENDING", payment.getStatus());
    }

    @Test
    void testMarkSuccess() {
        System.out.println("DEBUG: Marking payment as SUCCESS...");
        payment.markSuccess();
        System.out.println("DEBUG: Current Status = " + payment.getStatus());

        assertEquals("SUCCESS", payment.getStatus());
        assertNotEquals("FAILED", payment.getStatus());
    }

    @Test
    void testMarkFailed() {
        System.out.println("DEBUG: Marking payment as FAILED...");
        payment.markFailed();
        System.out.println("DEBUG: Current Status = " + payment.getStatus());

        assertEquals("FAILED", payment.getStatus());
        assertFalse(payment.getStatus().equals("SUCCESS"));
    }

    @Test
    void testPaymentIdNotNull() {
        System.out.println("DEBUG: Checking Payment ID...");
        assertNotNull(payment.getPaymentId());
    }

    @Test
    void testInstanceType() {
        System.out.println("DEBUG: Checking object instance...");
        assertInstanceOf(Payment.class, payment);
    }
}