import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class gradeCalcTest {

    private gradeCalc grCalculation;

    @BeforeEach
    void setUp() {
        grCalculation = new gradeCalc();
    }

    @Test
    @DisplayName("Grade O for percentage >= 90")
    void testForO() {
        assertEquals("O", grCalculation.grade(99));
        assertNotEquals("A", grCalculation.grade(99));
    }

    @Test
    void testForAPlus() {
        assertEquals("A+", grCalculation.grade(85));
    }

    @Test
    void testForA() {
        assertEquals("A", grCalculation.grade(79));
    }

    @Test
    void testForB() {
        assertEquals("B", grCalculation.grade(69));
    }

    @Test
    void testForC() {
        assertEquals("C", grCalculation.grade(58));
    }

    @Test
    void testForD() {
        assertEquals("D", grCalculation.grade(45));
    }

    @Test
    void testForFailBorder() {
        assertEquals("F", grCalculation.grade(39));
    }

    @Test
    void testForFail() {
        assertEquals("F", grCalculation.grade(10));
    }

    @Test
    void testForZero() {
        assertEquals("F", grCalculation.grade(0));
    }

    @Test
    void testForNegativePercentage() {
        assertThrows(IllegalArgumentException.class, () -> {
            grCalculation.grade(-11);
        });
    }
}
