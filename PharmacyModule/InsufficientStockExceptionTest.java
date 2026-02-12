import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsufficientStockExceptionTest {

    @Test
    void testExceptionMessage() {
        InsufficientStockException exception =
                new InsufficientStockException("Stock not available");

        assertEquals("Stock not available", exception.getMessage());
    }
}