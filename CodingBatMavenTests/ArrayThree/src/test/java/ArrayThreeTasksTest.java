import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by Sergey on 24.02.2019.
 */
public class ArrayThreeTasksTest {

    @Test
    public void linearIn() {
        ArrayThreeTasks arrayThreeTasks = new ArrayThreeTasks();
        int[] outerArray = {1, 2, 4, 6};
        int[] innerArray = {2, 4};
        boolean result = arrayThreeTasks.linearIn(outerArray, innerArray);
        Assert.assertEquals(result,true);
    }

    @Test
    public void linearInExpectedToFail() {
        ArrayThreeTasks arrayThreeTasks = new ArrayThreeTasks();
        int[] outerArray = {1, 2, 4, 6};
        int[] innerArray = {2, 4,5};
        boolean result = arrayThreeTasks.linearIn(outerArray, innerArray);
        Assert.assertEquals(result,false);
    }
}