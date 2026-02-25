import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PharmacyServiceTest {

    private PharmacyService service;

    @BeforeEach
    void setUp() {
        service = new PharmacyService();
        service.addMedicine(new Medicine(1, "Paracetamol", 10.0, 100));
        service.addMedicine(new Medicine(2, "Cough Syrup", 80.0, 50));
    }

    @Test
    void testServiceNotNull() {
        assertNotNull(service);
    }

    @Test
    void testPrescribeMedicineSuccess() throws Exception {
        double cost = service.prescribeMedicine(1, 5);
        assertEquals(50.0, cost);
        assertTrue(cost > 0);
    }

    @Test
    void testPrescribeMedicineFailure() {
        assertThrows(InsufficientStockException.class, () -> {
            service.prescribeMedicine(1, 500);
        });
    }

    @Test
    void testUpdateStockAndPrescribe() throws Exception {
        service.updateStock(1, 200);
        double cost = service.prescribeMedicine(1, 100);
        assertEquals(1000.0, cost);
        assertNotEquals(500.0, cost);
    }

    @Test
    void testDeleteMedicine() {

        service.deleteMedicine(2);

        assertThrows(IllegalArgumentException.class, () -> {
            service.prescribeMedicine(2, 1);
        });
    }

    @RepeatedTest(2)
    void testRepeatedPrescription() throws Exception {
        double cost = service.prescribeMedicine(1, 1);
        assertEquals(10.0, cost);
        assertTrue(cost == 10.0);
    }
}