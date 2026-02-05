import org.junit.*;

public class addTest {
    
    @Test
    public void Test1forAdd() {
        add add_obj = new add();

        Assert.assertEquals(7, add_obj.addNumbers(4,3));
        Assert.assertEquals(-7,add_obj.addNumbers(-4, -3));
        Assert.assertEquals(0,add_obj.addNumbers(-4, 4));
    }
}
