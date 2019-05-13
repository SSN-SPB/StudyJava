import org.junit.Before;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class StringTwoMethodsTest {
    @BeforeTest
    public void startRequiredClass(){
        //StringTwoMethods stringTwoMethods = new StringTwoMethods();
        System.out.println(" PrintOut StringTwoMethodsTest before class");

    }

    @Test (groups = "doubleChar", priority = 2)
    public void testDoubleChar() {
        System.out.println("\n" + Object.class.getName() + " " + Object.class.getClass() + "\n");
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        String initString ="The";
        Assert.assertEquals(stringTwoMethods.doubleChar(initString),"TThhee");

    }

    @Test (groups = "doubleChar2", priority = 1)
    public void testDoubleCharExpectedToFail() {
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        String initString ="The";
        Assert.assertNotSame(stringTwoMethods.doubleChar(initString),"TThheed");
      //  Assert.assertEquals(stringTwoMethods.doubleChar(initString),"TThheed");

    }

  /*  @Test (groups = { "testCountCode" })
    public void testCountCode() throws Exception {
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        String testString ="codexxcode";
        Assert.assertEquals(2, stringTwoMethods.countCode(testString));
    }*/

    @AfterClass
    public void AfterRequiredClass(){
        //StringTwoMethods stringTwoMethods = new StringTwoMethods();
        System.out.println(" PrintOut StringTwoMethodsTest class");

    }

    @Test
    public void testConCat() {
        StringTwoMethods concatTest = new StringTwoMethods();
        String result = concatTest.conCat("test", "bob");
        Assert.assertEquals(result,"testbob");

    }
    @Test
    public void testConCat2() {
        StringTwoMethods concatTest = new StringTwoMethods();
        String expectedString = concatTest.conCat("abc", "cat") ;
        Assert.assertEquals(expectedString,"abcat");

    }
    @Test
    public void testConCat3() {
        StringTwoMethods concatTest = new StringTwoMethods();
        String expectedString = concatTest.conCat("abc", "cat") ;
        Assert.assertEquals(expectedString,"abcat");

    }

    @Test
    public void testConCat4() {
        StringTwoMethods concatTest = new StringTwoMethods();
        String expectedString = concatTest.conCat("abc", "") ;
        Assert.assertEquals(expectedString,"abc");

    }
}