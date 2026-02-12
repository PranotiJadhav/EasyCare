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




























// MedicineTest.java
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// class MedicineTest {

//     @Test
//     void testMedicineCreation() {
//         Medicine medicine = new Medicine(1, "Paracetamol", 10.0, 100);

//         assertEquals(1, medicine.getId());
//         assertEquals("Paracetamol", medicine.getName());
//         assertEquals(10.0, medicine.getPrice());
//         assertEquals(100, medicine.getStock());
//     }

//     @Test
//     void testSetStock() {
//         Medicine medicine = new Medicine(1, "Paracetamol", 10.0, 100);
//         medicine.setStock(80);

//         assertEquals(80, medicine.getStock());
//     }
// }


// PharmacyServiceTest.java
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

// import static org.junit.jupiter.api.Assertions.*;

// class PharmacyServiceTest {

//     private PharmacyService service;

//     @BeforeEach
//     void setup() {
//         service = new PharmacyService();
//         service.addMedicine(new Medicine(1, "Paracetamol", 10.0, 100));
//     }

//     @Test
//     void testAddMedicine() {
//         assertDoesNotThrow(() ->
//                 service.addMedicine(new Medicine(2, "Cough Syrup", 80.0, 50))
//         );
//     }

//     @Test
//     void testPrescribeMedicineSuccess() throws Exception {
//         double cost = service.prescribeMedicine(1, 5);
//         assertEquals(50.0, cost);
//     }

//     @Test
//     void testPrescribeMedicineInsufficientStock() {
//         assertThrows(InsufficientStockException.class, () -> {
//             service.prescribeMedicine(1, 500);
//         });
//     }

//     @Test
//     void testUpdateStock() {
//         service.updateStock(1, 200);
//         double cost = 0;

//         try {
//             cost = service.prescribeMedicine(1, 100);
//         } catch (Exception ignored) {}

//         assertEquals(1000.0, cost);
//     }

//     @Test
//     void testDeleteMedicine() {
//         service.deleteMedicine(1);
//         assertThrows(InsufficientStockException.class, () -> {
//             service.prescribeMedicine(1, 1);
//         });
//     }
// }

// ExcpetionTest.java
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;

// class InsufficientStockExceptionTest {

//     @Test
//     void testExceptionMessage() {
//         InsufficientStockException exception =
//                 new InsufficientStockException("Stock not available");

//         assertEquals("Stock not available", exception.getMessage());
//     }
// }


