import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by idnkiw on 8/31/2016.
 */

public class MyfirstTest {
    @Test
    public void myFirstTest() {
        Assert.assertEquals(1, 1);
    }
    @Test
    public void myFirstTest2() {
        Assert.assertEquals(1, 1);
    }
    @Test
    public void myFirstTest3() {
        Assert.assertEquals(MainClass.getFirsttSuiteName(), "suite");
    }
}
