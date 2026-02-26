package BillingPayments.src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import BillingPayments.src.main.Invoice;

import static org.junit.jupiter.api.Assertions.*;

class InvoiceTest {

    private Invoice invoice;

    @BeforeEach
    void setUp() {
        System.out.println("DEBUG: Setting up Invoice object...");
        invoice = new Invoice(500, 200, 300);
    }

    @Test
    void testTotalCalculation() {
        System.out.println("DEBUG: Testing total calculation...");
        System.out.println("DEBUG: Expected = 1000, Actual = " + invoice.getTotalAmount());

        assertEquals(1000, invoice.getTotalAmount());
        assertNotEquals(900, invoice.getTotalAmount());
    }

    @Test
    void testInvoiceIdNotNull() {
        System.out.println("DEBUG: Checking if Invoice ID is generated...");
        assertNotNull(invoice.getInvoiceId());
    }

    @Test
    void testInitialPaidStatus() {
        System.out.println("DEBUG: Checking initial paid status...");
        assertFalse(invoice.isPaid());
    }

    @Test
    void testMarkAsPaid() {
        System.out.println("DEBUG: Marking invoice as paid...");
        invoice.markAsPaid();
        assertTrue(invoice.isPaid());
    }

    @Test
    void testNegativeCharges() {
        System.out.println("DEBUG: Testing negative charge exception...");
        assertThrows(IllegalArgumentException.class, () -> new Invoice(-100, 200, 300));
    }

    @RepeatedTest(3)
    void testMultipleInvoiceCreation() {
        System.out.println("DEBUG: Repeated test - Creating new Invoice...");
        Invoice inv = new Invoice(100, 100, 100);
        System.out.println("DEBUG: Total = " + inv.getTotalAmount());
        assertEquals(300, inv.getTotalAmount());
    }
}