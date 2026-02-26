package BillingPayments.src.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import BillingPayments.src.main.BillingService;
import BillingPayments.src.main.Invoice;
import BillingPayments.src.main.Payment;

import static org.junit.jupiter.api.Assertions.*;

class BillingServiceTest {

    private BillingService billingService;
    private Invoice invoice;

    @BeforeEach
    void setUp() {
        System.out.println("DEBUG: Initializing BillingService...");
        billingService = new BillingService();
        invoice = billingService.generateInvoice(500, 200, 300);
        System.out.println("DEBUG: Invoice Created with ID = " + invoice.getInvoiceId());
    }

    @Test
    void testInvoiceGeneration() {
        System.out.println("DEBUG: Testing invoice generation...");
        assertNotNull(invoice);
        assertEquals(1000, invoice.getTotalAmount());
        assertEquals(1, billingService.getTotalInvoices());
    }

    @Test
    void testGetInvoice() {
        System.out.println("DEBUG: Fetching invoice by ID...");
        Invoice fetched = billingService.getInvoice(invoice.getInvoiceId());
        assertEquals(invoice.getInvoiceId(), fetched.getInvoiceId());
    }

    @Test
    void testSuccessfulPayment() {
        System.out.println("DEBUG: Testing successful payment...");
        Payment payment = billingService.makePayment(invoice.getInvoiceId(), 1000);

        System.out.println("DEBUG: Payment Status = " + payment.getStatus());

        assertAll(
                () -> assertEquals("SUCCESS", payment.getStatus()),
                () -> assertTrue(invoice.isPaid()),
                () -> assertEquals(1, billingService.getTotalPayments()));
    }

    @Test
    void testFailedPayment_LessAmount() {
        System.out.println("DEBUG: Testing failed payment (less amount)...");
        Payment payment = billingService.makePayment(invoice.getInvoiceId(), 500);

        System.out.println("DEBUG: Payment Status = " + payment.getStatus());

        assertEquals("FAILED", payment.getStatus());
        assertFalse(invoice.isPaid());
    }

    @Test
    void testFailedPayment_ExtraAmount() {
        System.out.println("DEBUG: Testing failed payment (extra amount)...");
        Payment payment = billingService.makePayment(invoice.getInvoiceId(), 1500);

        System.out.println("DEBUG: Payment Status = " + payment.getStatus());

        assertEquals("FAILED", payment.getStatus());
    }

    @Test
    void testPaymentForInvalidInvoice() {
        System.out.println("DEBUG: Testing invalid invoice payment...");
        assertThrows(IllegalArgumentException.class, () -> billingService.makePayment("INVALID_ID", 1000));
    }

    @Test
    void testZeroPaymentAmount() {
        System.out.println("DEBUG: Testing zero payment exception...");
        assertThrows(IllegalArgumentException.class, () -> billingService.makePayment(invoice.getInvoiceId(), 0));
    }

    @Test
    void testNullInvoiceFetch() {
        System.out.println("DEBUG: Fetching non-existing invoice...");
        assertNull(billingService.getInvoice("WRONG_ID"));
    }

    @RepeatedTest(3)
    void testMultipleInvoiceCreation() {
        System.out.println("DEBUG: Repeated invoice creation test...");
        billingService.generateInvoice(100, 100, 100);
        System.out.println("DEBUG: Total invoices now = " + billingService.getTotalInvoices());
        assertTrue(billingService.getTotalInvoices() >= 1);
    }
}