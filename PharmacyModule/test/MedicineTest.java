package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import src.main.Medicine;

import static org.junit.jupiter.api.Assertions.*;

class MedicineTest {

    private Medicine medicine;

    @BeforeEach
    void setUp() {
        medicine = new Medicine(1, "Paracetamol", 10.0, 100);
    }

    @Test
    void testMedicineObjectNotNull() {
        assertNotNull(medicine);
    }

    @Test
    void testMedicineProperties() {
        assertEquals(1, medicine.getId());
        assertEquals("Paracetamol", medicine.getName());
        assertEquals(10.0, medicine.getPrice());
        assertEquals(100, medicine.getStock());
    }

    @Test
    void testStockUpdate() {
        medicine.setStock(80);
        assertEquals(80, medicine.getStock());
        assertNotEquals(100, medicine.getStock());
    }

    @RepeatedTest(3)
    void testRepeatedStockCheck() {
        assertTrue(medicine.getStock() > 0);
        assertFalse(medicine.getStock() < 0);
    }
}