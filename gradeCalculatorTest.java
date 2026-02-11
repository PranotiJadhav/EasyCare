import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

public class gradeCalculatorTest {

    gradeCalculator grCalculation = new gradeCalculator();

    @BeforeEach
    void setUp() {
        grCalculation = new gradeCalculator();
    }

    @Test
    @DisplayName("Tests for if-else if")
    public void testforO() {
        Assert.assertEquals("O", grCalculation.calGrade(99));
        System.out.println("Grade O...");
        Assert.assertNotEquals("A", grCalculation.calGrade(99));
        System.out.println("Grade O not A");
    }

    @Test
    public void testforAA() {
        Assert.assertEquals("A+", grCalculation.calGrade(85));
        System.out.println("Grade A+");
    }

    @Test
    public void testforA() {
        Assert.assertEquals("A", grCalculation.calGrade(79));
        System.out.println("Grade A");
    }

    @Test
    public void testforB() {
        Assert.assertEquals("B", grCalculation.calGrade(69));
        System.out.println("Grade B");
    }

    @Test
    public void testforC() {
        Assert.assertEquals("C", grCalculation.calGrade(58));
        System.out.println("Grade C");
    }

    @Test
    public void testforD() {
        Assert.assertEquals("D", grCalculation.calGrade(45));
        System.out.println("Grade D");
    }

    @Test
    public void testforBorderCase() {
        Assert.assertEquals("F", grCalculation.calGrade(39));
        System.out.println("Grade F Border Case");
    }

    @Test
    public void testforF() {
        Assert.assertEquals("F", grCalculation.calGrade(10));
        System.out.println("Grade F");
    }

    @Test
    public void testforZero() {
        Assert.assertEquals("F", grCalculation.calGrade(0));
        System.out.println("Grade F for Zero ...");
    }

    @Test
    public void testforNegNum() {
        Assert.assertThrows(IllegalArgumentException.class, () -> {
            grCalculation.calGrade(-11);
        });
        System.out.println("Test for negative number");
    }
}
