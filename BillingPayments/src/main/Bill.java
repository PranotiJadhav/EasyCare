package BillingPayments.src.main;

import java.util.ArrayList;
import java.util.List;

public class Bill {

    private String patientId;
    private List<Double> charges;
    private boolean paid;

    public Bill(String patientId) {
        this.patientId = patientId;
        this.charges = new ArrayList<>();
        this.paid = false;
    }

    public String getPatientId() {
        return patientId;
    }

    public boolean isPaid() {
        return paid;
    }

    public void addCharge(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Charge must be positive");
        }
        charges.add(amount);
    }

    public double calculateTotal() {
        double total = 0;
        for (double charge : charges) {
            total += charge;
        }
        return total;
    }

    public void markAsPaid() {
        this.paid = true;
    }
}