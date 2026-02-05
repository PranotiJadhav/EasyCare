import org.junit.*;

public class addCTest {
    
    @Test
    public void test1forAddC() {
        addC add = new addC();

        Assert.assertEquals(Math.addExact(10, 5), add.addNum(10, 5));
        Assert.assertEquals(Math.addExact(0, 0), add.addNum(0, 0));
        Assert.assertEquals(Math.addExact(-4, 3), add.addNum(-4, 3));
        Assert.assertEquals(Math.addExact(4, -3), add.addNum(4, -3));
        Assert.assertEquals(Math.addExact(-4, -3), add.addNum(-4, -3));
    }
}
