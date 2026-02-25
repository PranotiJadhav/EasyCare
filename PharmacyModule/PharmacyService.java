import java.util.*;

public class PharmacyService {

    private Map<Integer, Medicine> medicineMap = new HashMap<>();

    // Add Medicine
    public void addMedicine(Medicine medicine) {
        medicineMap.put(medicine.getId(), medicine);
        System.out.println("Medicine added successfully.");
    }

    // View All Medicines
    public void viewAllMedicines() {
        if (medicineMap.isEmpty()) {
            System.out.println("No medicines available.");
            return;
        }

        for (Medicine m : medicineMap.values()) {
            System.out.println(m);
        }
    }

    // Update Stock
    public void updateStock(int id, int newStock) {
        Medicine medicine = medicineMap.get(id);
        if (medicine != null) {
            medicine.setStock(newStock);
            System.out.println("Stock updated successfully.");
        } else {
            System.out.println("Medicine not found.");
        }
    }

    // Prescribe Medicine (Reduce Stock)
    public double prescribeMedicine(int id, int quantity) throws InsufficientStockException {

        Medicine medicine = medicineMap.get(id);

        if (medicine == null) {
            throw new IllegalArgumentException("Medicine not found");
        }

        if (medicine.getStock() < quantity) {
            throw new InsufficientStockException("Not enough stock available.");
        }

        medicine.setStock(medicine.getStock() - quantity);

        double totalCost = quantity * medicine.getPrice();
        System.out.println("Medicine prescribed successfully.");
        return totalCost;
    }

    // Delete Medicine
    public boolean deleteMedicine(int id) {
        if (medicineMap.remove(id) != null) {
            System.out.println("Medicine deleted successfully.");
            return true;
        } else {
            System.out.println("Medicine not found.");
            return false;
        }
    }
}
