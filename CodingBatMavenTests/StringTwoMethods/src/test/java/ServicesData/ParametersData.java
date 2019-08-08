package ServicesData;

import org.testng.annotations.DataProvider;

public class ParametersData {
    @DataProvider(name = "CountHi")
    public static Object[][] dataProvider() {
        return new Object[][]
                {
                        {"AHIBhiChi hi", 3},
                        {"Ahi hi", 2},
                        {" hi", 1},
                        {" hi", 2},
                        {" hiahi", 2},
                        {" hihi", 2},
                        {" hihihi hihihi hi", 7},
                        {" hihihi hihihi hi", 1},
                        {"Ahi hihihihhi", 5}
                };
    }

    @DataProvider(name = "doubleCharDataProvider")
    public static Object[][] doubleChar() {
        return new Object[][]
                {
                        {"hi", "hhii"},
                        {"step", "sstteepp"},
                        {"the", "tthhee"},
                        {"he", "hhee"},
                        {"hii", "hhiiii"}

                };
    }
    @DataProvider(name = "matchUp")
    public static Object[][] matchUp () {
        return new Object[][]
                {
                        {123239, 2},
                        {123239, 2}

                };
    }
}
/*
@DataProvider(name = "matchUp")
    public static Object[][] matchUp () {
        return new Object[][]
                {

                        { [1, 2, 3], [2, 3, 10], 2},
                        { [1, 2, 3], [2, 3, 10], 2}

                };

    }
}
*/
