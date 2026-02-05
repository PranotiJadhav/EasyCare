import org.junit.*;


public class addPranotiTest {

    @Test
    public void test1ofAdd() 
    {
        addPranoti add_var = new addPranoti();
        Assert.assertEquals(10, add_var.addNumbers(5, 5));
        Assert.assertEquals(10, add_var.addNumbers(10, 0));
    }
}
