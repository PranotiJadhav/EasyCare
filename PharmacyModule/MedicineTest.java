import org.junit.*;
import static org.junit.jupiter.api.Assertions.*;

public class MedicineTest {
    
    @Test
    public void testMedicineCreation() {
        Medicine medicine = new Medicine(1, "Paracetamol", 10.0, 100);

        assertEquals(1, medicine.getId());
        assertEquals("Paracetamol", medicine.getName());
        assertEquals(10.0, medicine.getPrice());
        assertEquals(100, medicine.getStock());
    }

    @Test
    public void testSetStock() {
        Medicine medicine = new Medicine(1, "Paracetamol", 10.0, 100);
        medicine.setStock(80);

        assertEquals(80, medicine.getStock());
    }

}

