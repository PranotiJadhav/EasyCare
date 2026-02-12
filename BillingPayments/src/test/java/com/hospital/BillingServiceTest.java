package BillingPayments.src.test.java.com.hospital;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BillingPayments.src.main.java.com.hospital.BillingService;

import static org.junit.jupiter.api.Assertions.*;

public class BillingServiceTest {

    private BillingService billingService;

    @BeforeEach
    void setup() {
        billingService = new BillingService();
    }

    @Test
    void testCreateBillSuccessfully() {
        billingService.createBill("P101");
        assertNotNull(billingService.getBill("P101"));
    }

    @Test
    void testCreateDuplicateBill() {
        billingService.createBill("P101");

        assertThrows(IllegalArgumentException.class, () -> {
            billingService.createBill("P101");
        });
    }

    @Test
    void testAddChargeSuccessfully() {
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);

        double total = billingService.getTotal("P101");
        assertEquals(500, total);
    }

    @Test
    void testAddNegativeCharge() {
        billingService.createBill("P101");

        assertThrows(IllegalArgumentException.class, () -> {
            billingService.addCharge("P101", -200);
        });
    }

    @Test
    void testBillNotFoundWhileAddingCharge() {
        assertThrows(RuntimeException.class, () -> {
            billingService.addCharge("P999", 500);
        });
    }

    @Test
    void testCalculateTotalMultipleCharges() {
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);
        billingService.addCharge("P101", 300);

        double total = billingService.getTotal("P101");
        assertEquals(800, total);
    }
}