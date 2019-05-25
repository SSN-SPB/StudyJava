import ServicesData.ParametersData;
import org.junit.Before;
import org.junit.Ignore;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static org.testng.Assert.*;

public class StringTwoMethodsDoubleCharTest {
    @BeforeTest
    public void startRequiredClass(){
        // Get the class name
        String className = this.getClass().getName();
        System.out.println(" The following list of test is in this class: " + className);
        Class aClass = this.getClass();

        // Get the methods
        Method[] methods = aClass.getDeclaredMethods();

        // Loop through the methods and print out their names
        for (Method method : methods) {
            System.out.println(method.getName());
        }

    }
    @Test (dataProvider = "doubleCharDataProvider", dataProviderClass = ParametersData.class)
    public void testCountHiPositive(String testString, String ethalon){
        StringTwoMethods stringTwoMethods = new StringTwoMethods();
        Object resultString = stringTwoMethods.doubleChar(testString) ;
        System.out.println("ethalon: " + ethalon + " result: " + resultString);
            Assert.assertEquals(resultString,ethalon, "TestResult:");
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



    @AfterClass
    public void AfterRequiredClass(){
        //StringTwoMethods stringTwoMethods = new StringTwoMethods();
        System.out.println(" PrintOut StringTwoMethodsDoubleCharTest after class");

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