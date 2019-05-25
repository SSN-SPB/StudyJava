import ServicesData.ParametersData;
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

    @Test
    public void testCountHiFourNegative() {
        StringTwoMethods countHi = new StringTwoMethods(); int countHiValue = countHi.countHi("AHIBhiChi hi eeehi") ;
        Assert.assertNotSame(countHiValue,5);

    }



    @Test (dataProvider = "CountHi", dataProviderClass = ParametersData.class)
    public void testCountHiPositive(String testString, int resultValue){
        StringTwoMethods countHi = new StringTwoMethods();
        Object countHiValue = countHi.countHi(testString) ;
        //Assert.assertEquals(countHiValue,resultValue);
        System.out.println("Expected: " + countHiValue + "; Actual: " + resultValue);

        try {
            Assert.assertEquals(countHiValue,resultValue, "TestResult:");
        } catch (AssertionError e) {
//            e.printStackTrace();
            System.out.println("The test above has failed:" + " String: '" + testString + "' is counted as " + resultValue + " while is expected: " + countHiValue);
            System.out.println(e.getLocalizedMessage());
          //  throw e;
            Assert.fail();
        }
    }
    }
