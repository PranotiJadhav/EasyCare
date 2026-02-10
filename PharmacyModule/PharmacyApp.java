public class PharmacyApp {

    public static void main(String[] args) {

        PharmacyService service = new PharmacyService();

        // Adding Medicines
        service.addMedicine(new Medicine(1, "Paracetamol", 10.0, 100));
        service.addMedicine(new Medicine(2, "Cough Syrup", 80.0, 50));

        // View Medicines
        service.viewAllMedicines();

        try {
            // Prescribing Medicine
            double cost = service.prescribeMedicine(1, 5);
            System.out.println("Total Cost: ₹" + cost);
        } catch (InsufficientStockException e) {
            System.out.println(e.getMessage());
        }

        // View After Prescription
        service.viewAllMedicines();
    }
}
