package BillingPayments.src.main;

import java.util.HashMap;
import java.util.Map;

public class BillingService {

    private Map<String, Invoice> invoiceMap = new HashMap<>();
    private Map<String, Payment> paymentMap = new HashMap<>();

    // Generate Invoice
    public Invoice generateInvoice(double doctorFee, double medicineCost, double labCharges) {

        Invoice invoice = new Invoice(doctorFee, medicineCost, labCharges);
        invoiceMap.put(invoice.getInvoiceId(), invoice);
        return invoice;
    }

    // Get Invoice
    public Invoice getInvoice(String invoiceId) {
        return invoiceMap.get(invoiceId);
    }

    // Make Payment
    public Payment makePayment(String invoiceId, double amount) {

        if (!invoiceMap.containsKey(invoiceId)) {
            throw new IllegalArgumentException("Invoice not found");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }

        Invoice invoice = invoiceMap.get(invoiceId);
        Payment payment = new Payment(invoiceId, amount);

        if (amount == invoice.getTotalAmount()) {
            payment.markSuccess();
            invoice.markAsPaid();
        } else {
            payment.markFailed();
        }

        paymentMap.put(payment.getPaymentId(), payment);
        return payment;
    }

    public Payment getPayment(String paymentId) {
        return paymentMap.get(paymentId);
    }

    public int getTotalInvoices() {
        return invoiceMap.size();
    }

    public int getTotalPayments() {
        return paymentMap.size();
    }
}