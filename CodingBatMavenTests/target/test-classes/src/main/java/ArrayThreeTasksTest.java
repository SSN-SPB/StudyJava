package src.main.java;

//import org.testng.Assert;
import org.testng.Assert;
import org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



/**
 * Created by Sergey on 24.02.2019.
 */
public class ArrayThreeTasksTest {

    /*@BeforeClass
    public void setUp() throws Exception {
ArrayThreeTasks arrayThreeTasks = new ArrayThreeTasks();
    }*/

    @Test
    public void testLinearIn() throws Exception {
//        ArrayThreeTasks arrayThreeTasks = new ArrayThreeTasks();
        ArrayThreeTasks arrayThreeTasks = new ArrayThreeTasks();
        int [] outerArray = {1,2, 4,6};
        int [] innerArray = {2, 4};
        boolean result = arrayThreeTasks.linearIn(outerArray,innerArray);
        Assert.assertEquals(result,true);



    }
}