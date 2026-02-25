import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsufficientStockExceptionTest {

    @Test
    void testExceptionCreation() {
        InsufficientStockException exception =
                new InsufficientStockException("Not enough stock");

        assertNotNull(exception);
        assertEquals("Not enough stock", exception.getMessage());
    }

    @Test
    void testExceptionMessageNotEqual() {
        InsufficientStockException exception =
                new InsufficientStockException("Stock issue");

        assertNotEquals("Different message", exception.getMessage());
        assertTrue(exception.getMessage().contains("Stock"));
        assertFalse(exception.getMessage().isEmpty());
    }
}