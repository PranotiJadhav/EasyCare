// package test;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.RepeatedTest;
// import org.junit.jupiter.api.Test;

// import src.main.Medicine;

// import static org.junit.jupiter.api.Assertions.*;

// class MedicineTest {

//     private Medicine medicine;

//     @BeforeEach
//     void setUp() {
//         medicine = new Medicine(1, "Paracetamol", 10.0, 100);
//     }

//     @Test
//     void testMedicineObjectNotNull() {
//         assertNotNull(medicine);
//     }

//     @Test
//     void testMedicineProperties() {
//         assertEquals(1, medicine.getId());
//         assertEquals("Paracetamol", medicine.getName());
//         assertEquals(10.0, medicine.getPrice());
//         assertEquals(100, medicine.getStock());
//     }

//     @Test
//     void testStockUpdate() {
//         medicine.setStock(80);
//         assertEquals(80, medicine.getStock());
//         assertNotEquals(100, medicine.getStock());
//     }

//     @RepeatedTest(3)
//     void testRepeatedStockCheck() {
//         assertTrue(medicine.getStock() > 0);
//         assertFalse(medicine.getStock() < 0);
//     }
// }

package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import src.main.Medicine;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MedicineTest {

    private Medicine medicine;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Starting Medicine Tests");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Completed Medicine Tests");
    }

    @BeforeEach
    void setUp() {
        medicine = new Medicine(1, "Paracetamol", 10.0, 100);
    }

    @AfterEach
    void tearDown() {
        System.out.println("Medicine Test Completed");
    }

    @Test
    @Order(1)
    @DisplayName("Check Medicine Object Is Not Null")
    void testMedicineObjectNotNull() {
        assertNotNull(medicine);
    }

    @Test
    @Order(2)
    @DisplayName("Verify Medicine Properties")
    void testMedicineProperties() {
        assertEquals(1, medicine.getId());
        assertEquals("Paracetamol", medicine.getName());
        assertEquals(10.0, medicine.getPrice());
        assertEquals(100, medicine.getStock());
    }

    @Test
    @Order(3)
    @DisplayName("Verify Stock Update Functionality")
    void testStockUpdate() {
        medicine.setStock(80);
        assertEquals(80, medicine.getStock());
        assertNotEquals(100, medicine.getStock());
    }

    @RepeatedTest(3)
    @Order(4)
    @DisplayName("Repeated Stock Validation Test")
    void testRepeatedStockCheck() {
        assertTrue(medicine.getStock() > 0);
        assertFalse(medicine.getStock() < 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {50, 60, 70})
    @Order(5)
    @DisplayName("Parameterized Stock Update Test")
    void testParameterizedStock(int stockValue) {
        medicine.setStock(stockValue);
        assertEquals(stockValue, medicine.getStock());
        assertTrue(medicine.getStock() > 0);
    }
}

