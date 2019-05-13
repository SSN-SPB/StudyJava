import org.testng.Assert;
import org.testng.annotations.Test;


public class StringTwoMethodsContHiTest {

    @Test
    public void testCountHi() {
            StringTwoMethods countHi = new StringTwoMethods(); int countHiValue = countHi.countHi("hihi") ;
            Assert.assertEquals(countHiValue,2);

        }    @Test
    public void testCountHiTwoPositive() {
            StringTwoMethods countHi = new StringTwoMethods(); int countHiValue = countHi.countHi("AHIBhiChi hi") ;
            Assert.assertEquals(countHiValue,3);

        }
    }
