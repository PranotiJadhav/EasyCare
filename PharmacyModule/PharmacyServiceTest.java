import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PharmacyServiceTest {

    PharmacyService service;

    @BeforeEach
    public void setup() {
        service = new PharmacyService();
        service.addMedicine(new Medicine(1, "Paracetamol", 10.0, 100));
    }

    @Test
    public void testAddMedicine() {
        assertDoesNotThrow(() -> 
            service.addMedicine(new Medicine(2, "Cough Syrup", 80.0, 50)));
    }

    @Test
    public void testPresribeMedicine() throws InsufficientStockException {
        double cost = service.prescribeMedicine(1, 5);
        assertEquals(50,cost);
    }

    @Test
    public void testPrescribeMedicineInsufficientStock() {
        assertThrows(InsufficientStockException.class, () -> {
            service.prescribeMedicine(1, 500);
        });
    }

    @Test
    public void testUpdateStock() {
        service.updateStock(1, 200);
        double cost = 0;

        try {
            cost = service.prescribeMedicine(1, 100);
        } catch (Exception ignored) {}

        assertEquals(1000.0, cost);
    }

    @Test
    public void testDeleteMedicine() {
        assertEquals(true, service.deleteMedicine(1));
    }
}