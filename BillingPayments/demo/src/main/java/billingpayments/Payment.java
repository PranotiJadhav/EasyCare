package billingpayments;

import java.util.UUID;

public class Payment {

    private String paymentId;
    private String invoiceId;
    private double amount;
    private String status; // "SUCCESS" or "FAILED"

    public Payment(String invoiceId, double amount) {
        this.paymentId = UUID.randomUUID().toString();
        this.invoiceId = invoiceId;
        this.amount = amount;
        this.status = "PENDING";
    }

    public String getPaymentId() {
        return paymentId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public void markSuccess() {
        this.status = "SUCCESS";
    }

    public void markFailed() {
        this.status = "FAILED";
    }
}