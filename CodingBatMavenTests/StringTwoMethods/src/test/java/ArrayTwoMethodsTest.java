import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ArrayTwoMethodsTest {

    @Test (groups = "mathcUpGroup" , priority = 10)
    public void testMatchUp1() {
        ArrayTwoMethods arrayTwoMethods = new ArrayTwoMethods();
        int[] n1 = {1, 2, 3};
        int[] n2 = {2, 3, 10};
        int expectedCounter=2;
        int resultCounter = arrayTwoMethods.matchUp(n1,n2);

        Assert.assertEquals(expectedCounter, resultCounter);
    }

    @Test (groups = "doubleChar" , priority = 10)
    public void testDoubleCharExpectedToFail() {
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        String initString ="The";
        Assert.assertNotSame(stringTwoMethods.doubleChar(initString),"TThheed");
        //  Assert.assertEquals(stringTwoMethods.doubleChar(initString),"TThheed");

    }
}