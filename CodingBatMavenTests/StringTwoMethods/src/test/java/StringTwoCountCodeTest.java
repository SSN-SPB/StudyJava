import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StringTwoCountCodeTest {
    @BeforeTest
    public void startRequiredClass(){
        //StringTwoMethods stringTwoMethods = new StringTwoMethods();

    }


    @Test (groups = "doubleChar" , priority = 10)
    public void testDoubleCharExpectedToFail() {
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        String initString ="The";
        Assert.assertNotSame(stringTwoMethods.doubleChar(initString),"TThheed");
      //  Assert.assertEquals(stringTwoMethods.doubleChar(initString),"TThheed");

    }

    @Test (groups =  "testCountCode", priority = 3 )
    public void testCountCode() throws Exception {
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        String testString ="codexxcode";
        Assert.assertEquals(2, stringTwoMethods.countCode(testString));
    }

    @Test (groups = "testCountCode", invocationCount = 5, priority = 1)
    public void testCountCode2() throws Exception {
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        String testString ="codexxcode";
        Assert.assertEquals(2, stringTwoMethods.countCode(testString));
    }
    @Test (groups = "doubleChar",priority = 2 )
    public void testCountCode3() throws Exception {
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        String testString ="codexxcode";
        Assert.assertEquals(2, stringTwoMethods.countCode(testString));
    }
    @Test (groups = "testCountCode", priority = 11)
    public void testCountCode4() throws Exception {
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        String testString ="codexxcode";
        Assert.assertEquals(2, stringTwoMethods.countCode(testString));
    }
}