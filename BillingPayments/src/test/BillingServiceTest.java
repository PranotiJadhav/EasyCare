package BillingPayments.src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import BillingPayments.src.main.BillingService;

import static org.junit.jupiter.api.Assertions.*;

public class BillingServiceTest {

    private BillingService billingService;

    @BeforeEach
    void setup() {
        billingService = new BillingService();
    }

    @Test
    void testCreateBillSuccessfully() {
        System.out.println("Running testCreateBillSuccessfully");
        billingService.createBill("P101");
        System.out.println("Created bill for P101");
        assertNotNull(billingService.getBill("P101"));
    }

    @Test
    void testCreateDuplicateBill() {
        System.out.println("Running testCreateDuplicateBill");
        billingService.createBill("P101");

        System.out.println("Attempting to create duplicate bill for P101 (expect IllegalArgumentException)");
        assertThrows(IllegalArgumentException.class, () -> {
            billingService.createBill("P101");
        });
    }

    @Test
    void testAddChargeSuccessfully() {
        System.out.println("Running testAddChargeSuccessfully");
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);

        double total = billingService.getTotal("P101");
        System.out.println("Total after adding charge: " + total);
        assertEquals(500, total);
    }

    @Test
    void testAddNegativeCharge() {
        System.out.println("Running testAddNegativeCharge");
        billingService.createBill("P101");

        System.out.println("Attempting to add negative charge to P101 (expect IllegalArgumentException)");
        assertThrows(IllegalArgumentException.class, () -> {
            billingService.addCharge("P101", -200);
        });
    }

    @Test
    void testBillNotFoundWhileAddingCharge() {
        System.out.println("Running testBillNotFoundWhileAddingCharge");
        System.out.println("Attempting to add charge to non-existing bill P999 (expect RuntimeException)");
        assertThrows(RuntimeException.class, () -> {
            billingService.addCharge("P999", 500);
        });
    }

    @Test
    void testCalculateTotalMultipleCharges() {
        System.out.println("Running testCalculateTotalMultipleCharges");
        billingService.createBill("P101");
        billingService.addCharge("P101", 500);
        billingService.addCharge("P101", 300);

        double total = billingService.getTotal("P101");
        System.out.println("Total after multiple charges: " + total);
        assertEquals(800, total);
    }
}