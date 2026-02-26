// package test;
// import org.junit.jupiter.api.Test;

// import src.main.InsufficientStockException;

// import static org.junit.jupiter.api.Assertions.*;

// class InsufficientStockExceptionTest {

//     @Test
//     void testExceptionCreation() {
//         InsufficientStockException exception =
//                 new InsufficientStockException("Not enough stock");

//         assertNotNull(exception);
//         assertEquals("Not enough stock", exception.getMessage());
//     }

//     @Test
//     void testExceptionMessageNotEqual() {
//         InsufficientStockException exception =
//                 new InsufficientStockException("Stock issue");

//         assertNotEquals("Different message", exception.getMessage());
//         assertTrue(exception.getMessage().contains("Stock"));
//         assertFalse(exception.getMessage().isEmpty());
//     }
// }

package test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import src.main.InsufficientStockException;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class InsufficientStockExceptionTest {

    @BeforeAll
    static void initAll() {
        System.out.println("Starting InsufficientStockException Tests");
    }

    @AfterAll
    static void tearDownAll() {
        System.out.println("Completed InsufficientStockException Tests");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test Executed Successfully");
    }

    @Test
    @Order(1)
    @DisplayName("Test Exception Creation With Message")
    void testExceptionCreation() {
        InsufficientStockException exception =
                new InsufficientStockException("Not enough stock");

        assertNotNull(exception);
        assertEquals("Not enough stock", exception.getMessage());
    }

    @Test
    @Order(2)
    @DisplayName("Test Exception Message Validations")
    void testExceptionMessageNotEqual() {
        InsufficientStockException exception =
                new InsufficientStockException("Stock issue");

        assertNotEquals("Different message", exception.getMessage());
        assertTrue(exception.getMessage().contains("Stock"));
        assertFalse(exception.getMessage().isEmpty());
    }

    @ParameterizedTest
    @ValueSource(strings = {"Low stock", "Out of stock", "Stock unavailable"})
    @Order(3)
    @DisplayName("Parameterized Test For Multiple Messages")
    void testMultipleMessages(String message) {
        InsufficientStockException exception = new InsufficientStockException(message);

        assertEquals(message, exception.getMessage());
        assertNotNull(exception);
    }
}