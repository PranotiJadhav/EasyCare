
import org.junit.*;

public class add1Test {

    @Test

    public void Test1forAdd1(){
    add1 add_var=new add1();

    Assert.assertEquals(9, add_var.addNum(4,5));
    Assert.assertEquals(-10, add_var.addNum(-6,-4));
    Assert.assertEquals(290, add_var.addNum(300,-10));
   }

}
