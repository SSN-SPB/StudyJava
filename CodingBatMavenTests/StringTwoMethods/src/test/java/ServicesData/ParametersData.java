package ServicesData;

import org.testng.annotations.DataProvider;

public class ParametersData {
    @DataProvider(name = "CountHi")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        { "AHIBhiChi hi", 3 },
                        { "Ahi hi", 2 },
                        { " hi", 1 },
                        { " hi", 2 },
                        { " hihi", 2 },
                        { " hihihi hihihi hi", 7 },
                        { " hihihi hihihi hi", 1 },
                        { "Ahi hihihihhi", 5 }
                };
    }
}
