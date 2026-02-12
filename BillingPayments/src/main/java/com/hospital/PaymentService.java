package BillingPayments.src.main.java.com.hospital;

public class PaymentService {

    private BillingService billingService;

    public PaymentService(BillingService billingService) {
        this.billingService = billingService;
    }

    public void processPayment(String patientId, double paymentAmount) {

        Bill bill = billingService.getBill(patientId);

        if (bill == null) {
            throw new RuntimeException("Bill not found");
        }

        if (bill.isPaid()) {
            throw new IllegalStateException("Bill already paid");
        }

        double total = bill.calculateTotal();

        if (paymentAmount < total) {
            throw new IllegalArgumentException("Insufficient payment");
        }

        bill.markAsPaid();
    }
}