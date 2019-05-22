import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class StringTwoMethodsContHiTest {

    @Test
    public void testCountHi() {
            StringTwoMethods countHi = new StringTwoMethods(); int countHiValue = countHi.countHi("hihi") ;
            Assert.assertEquals(countHiValue,2);

        }

        @Test
    public void testCountHiTwoPositive() {
            StringTwoMethods countHi = new StringTwoMethods(); int countHiValue = countHi.countHi("AHIBhiChi hi") ;
            Assert.assertEquals(countHiValue,3);

        }
        /*@Test
    public void testCountHiThreePositive() {
            StringTwoMethods countHi = new StringTwoMethods(); int countHiValue = countHi.countHi("AHIBhiChi hi") ;
            Assert.assertNotSame(countHiValue,5);

        }*/

    @Test
    public void testCountHiFourPositive() {
        StringTwoMethods countHi = new StringTwoMethods(); int countHiValue = countHi.countHi("AHIBhiChi hi eeehi") ;
        Assert.assertNotSame(countHiValue,5);

    }


    @DataProvider(name = "CountHi")
    public Object[][] dataProvider() {
        return new Object[][]
                {
                        { "AHIBhiChi hi", 3 },
                        { "Ahi hi", 2 },
                        { " hi", 1 },
                        { " hi", 2 },
                        { " hihi", 2 },
                        { "Ahi hihihihhi", 5 }
                };
    }
    /*@DataProvider(name = "addMethodDataProvider")
    public Object[][] dataProvider() {
        return new Object[][] { { 2, 5, 7 }, { 3, 7, 10 }, { 4, 5, 9 } };
    }

    @Test(dataProvider = "addMethodDataProvider")
    public void testAddMethod(int a, int b, int result) {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(a, b), result);
    }*/

    @Test (dataProvider = "CountHi")
    public void testCountHiPositive(String testString, int resultValue) {
        StringTwoMethods countHi = new StringTwoMethods();
        Object countHiValue = countHi.countHi(testString) ;
        //Assert.assertEquals(countHiValue,resultValue);
        System.out.println("Expected: " + countHiValue + "; Actual: " + resultValue);

        Assert.assertEquals(countHiValue,resultValue, "TestResult:");

    }
    }
