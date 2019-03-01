import org.testng.Assert;
import org.testng.annotations.Test;

public class ArrayTwoTasksTest {

    @Test
    public void testNo14() {
        ArrayTwoTasks arrayTwoTasks = new ArrayTwoTasks();
            int [] testedNums = {1, 2, 3};
            boolean result=arrayTwoTasks.no14(testedNums);
            Assert.assertEquals(result,true);

        }

 @Test
    public void testNo14TestExpectedFalseOne() {
        ArrayTwoTasks arrayTwoTasks = new ArrayTwoTasks();
            int [] testedNums = {1, 4};
            boolean result=arrayTwoTasks.no14(testedNums);
            Assert.assertEquals(result,false);

        }
    @Test
    public void testNo14TestExpectedFalseTwo() {
        ArrayTwoTasks arrayTwoTasks = new ArrayTwoTasks();
        int [] testedNums = {1,3, 4};
        boolean result=arrayTwoTasks.no14(testedNums);
        Assert.assertEquals(result,false);

    }
    }
