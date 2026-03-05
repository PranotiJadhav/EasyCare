package billingpayments;

import java.util.UUID;

public class Invoice {

    private String invoiceId;
    private double doctorFee;
    private double medicineCost;
    private double labCharges;
    private double totalAmount;
    private boolean paid;

    public Invoice(double doctorFee, double medicineCost, double labCharges) {

        if (doctorFee < 0 || medicineCost < 0 || labCharges < 0) {
            throw new IllegalArgumentException("Charges cannot be negative");
        }

        this.invoiceId = UUID.randomUUID().toString();
        this.doctorFee = doctorFee;
        this.medicineCost = medicineCost;
        this.labCharges = labCharges;
        this.totalAmount = doctorFee + medicineCost + labCharges;
        this.paid = false;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public double getDoctorFee() {
        return doctorFee;
    }

    public double getMedicineCost() {
        return medicineCost;
    }

    public double getLabCharges() {
        return labCharges;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public boolean isPaid() {
        return paid;
    }

    public void markAsPaid() {
        this.paid = true;
    }
}