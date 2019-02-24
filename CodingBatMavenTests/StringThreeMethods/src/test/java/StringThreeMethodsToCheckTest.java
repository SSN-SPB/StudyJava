import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringThreeMethodsToCheckTest {

    @Test
    public void testCountYZ() {
        StringThreeMethodsToCheck stringThreeMethodsToCheck = new StringThreeMethodsToCheck();
        String initString ="fez day";
        int result=stringThreeMethodsToCheck.countYZ(initString);
        Assert.assertEquals(result,2);

    }

    @Test (groups = "doubleChar")
    public void testWithoutString() {
        StringThreeMethodsToCheck stringThreeMethodsToCheck = new StringThreeMethodsToCheck();
        String baseString ="abxxxxab";
        String removeString ="xx";
        String resultString=stringThreeMethodsToCheck.withoutString(baseString, removeString);
        String expectedString="abab";
        Assert.assertEquals(resultString,expectedString);
    }
    @Test
    public void testWithoutStringTwo() {
        StringThreeMethodsToCheck stringThreeMethodsToCheck = new StringThreeMethodsToCheck();
        String baseString ="abxxxxab";
        String removeString ="x";
        String resultString=stringThreeMethodsToCheck.withoutString(baseString, removeString);
        String expectedString="abab";
        Assert.assertEquals(resultString,expectedString);
    }
}