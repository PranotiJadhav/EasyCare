// package test;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.RepeatedTest;
// import org.junit.jupiter.api.Test;

// import src.main.InsufficientStockException;
// import src.main.Medicine;
// import src.main.PharmacyService;

// import static org.junit.jupiter.api.Assertions.*;

// class PharmacyServiceTest {

//     private PharmacyService service;

//     @BeforeEach
//     void setUp() {
//         service = new PharmacyService();
//         service.addMedicine(new Medicine(1, "Paracetamol", 10.0, 100));
//         service.addMedicine(new Medicine(2, "Cough Syrup", 80.0, 50));
//     }

//     @Test
//     void testServiceNotNull() {
//         assertNotNull(service);
//     }

//     @Test
//     void testPrescribeMedicineSuccess() throws Exception {
//         double cost = service.prescribeMedicine(1, 5);
//         assertEquals(50.0, cost);
//         assertTrue(cost > 0);
//     }

//     @Test
//     void testPrescribeMedicineFailure() {
//         assertThrows(InsufficientStockException.class, () -> {
//             service.prescribeMedicine(1, 500);
//         });
//     }

//     @Test
//     void testUpdateStockAndPrescribe() throws Exception {
//         service.updateStock(1, 200);
//         double cost = service.prescribeMedicine(1, 100);
//         assertEquals(1000.0, cost);
//         assertNotEquals(500.0, cost);
//     }

//     @Test
//     void testDeleteMedicine() {

//         service.deleteMedicine(2);

//         assertThrows(IllegalArgumentException.class, () -> {
//             service.prescribeMedicine(2, 1);
//         });
//     }

//     @RepeatedTest(2)
//     void testRepeatedPrescription() throws Exception {
//         double cost = service.prescribeMedicine(1, 1);
//         assertEquals(10.0, cost);
//         assertTrue(cost == 10.0);
//     }
// }

package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import src.main.InsufficientStockException;
import src.main.Medicine;
import src.main.PharmacyService;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class PharmacyServiceTest {

    private PharmacyService service;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting Pharmacy Service Tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Completed Pharmacy Service Tests");
    }

    @BeforeEach
    void setUp() {
        service = new PharmacyService();
        service.addMedicine(new Medicine(1, "Paracetamol", 10.0, 100));
        service.addMedicine(new Medicine(2, "Cough Syrup", 80.0, 50));
    }

    @AfterEach
    void tearDown() {
        System.out.println("Pharmacy Test Executed");
    }

    @Test
    @Order(1)
    void testServiceNotNull() {
        assertNotNull(service);
    }

    @Test
    @Order(2)
    void testPrescribeMedicineSuccess() throws Exception {
        double cost = service.prescribeMedicine(1, 5);
        assertEquals(50.0, cost);
        assertTrue(cost > 0);
    }

    @Test
    @Order(3)
    void testPrescribeMedicineFailure() {
        assertThrows(InsufficientStockException.class, () -> {
            service.prescribeMedicine(1, 500);
        });
    }

    @Test
    @Order(4)
    void testUpdateStockAndPrescribe() throws Exception {
        service.updateStock(1, 200);
        double cost = service.prescribeMedicine(1, 100);
        assertEquals(1000.0, cost);
        assertNotEquals(500.0, cost);
    }

    @Test
    @Order(5)
    void testDeleteMedicine() {

        service.deleteMedicine(2);

        assertThrows(IllegalArgumentException.class, () -> {
            service.prescribeMedicine(2, 1);
        });
    }

    @RepeatedTest(2)
    @Order(6)
    void testRepeatedPrescription() throws Exception {
        double cost = service.prescribeMedicine(1, 1);
        assertEquals(10.0, cost);
        assertTrue(cost == 10.0);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @Order(7)
    void testParameterizedPrescription(int quantity) throws Exception {
        double cost = service.prescribeMedicine(1, quantity);
        assertEquals(quantity * 10.0, cost);
        assertTrue(cost > 0);
    }

    @Nested
    @DisplayName("Nested Delete Tests")
    class DeleteTests {

        @Test
        void testDeleteExistingMedicine() {
            boolean result = service.deleteMedicine(1);
            assertTrue(result);
        }

        @Test
        void testDeleteNonExistingMedicine() {
            boolean result = service.deleteMedicine(999);
            assertFalse(result);
        }
    }
}