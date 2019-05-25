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
    @DataProvider(name = "doubleCharDataProvider")
    public static Object[][] doubleChar() {
        return new Object[][]
                {
                        { "hi", "hhii" },
                        { "step", "sstteepp" },
                        { "the", "tthhee" },
                        { "hii", "hhiiii" }

                };
    }
}
