package BillingPayments.src.main.java.com.hospital;
import java.util.HashMap;
import java.util.Map;

public class BillingService {

    private Map<String, Bill> bills = new HashMap<>();

    public void createBill(String patientId) {
        if (bills.containsKey(patientId)) {
            throw new IllegalArgumentException("Bill already exists");
        }
        bills.put(patientId, new Bill(patientId));
    }

    public void addCharge(String patientId, double amount) {
        Bill bill = bills.get(patientId);

        if (bill == null) {
            throw new RuntimeException("Bill not found");
        }

        bill.addCharge(amount);
    }

    public double getTotal(String patientId) {
        Bill bill = bills.get(patientId);

        if (bill == null) {
            throw new RuntimeException("Bill not found");
        }

        return bill.calculateTotal();
    }

    public Bill getBill(String patientId) {
        return bills.get(patientId);
    }
}