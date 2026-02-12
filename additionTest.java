//import java.beans.Transient;
import org.junit.*;

public class additionTest {
    @Test
    public void test1forAdd(){
        addition add_var = new addition();
        Assert.assertEquals(7, add_var.addnumbers(4,3));
        Assert.assertEquals(-7, add_var.addnumbers(-4,-3));
        Assert.assertEquals(201, add_var.addnumbers(201,0));
        //Assert.assertEquals(5, add_var.addnumbers(1,0));
    }
}

