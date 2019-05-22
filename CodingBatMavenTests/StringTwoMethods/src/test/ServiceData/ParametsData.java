import org.testng.annotations.DataProvider;

public class ParametsData {
    @DataProvider(name = "CountHi")
    public Object[][] dataProvider() {
        return new Object[][]
                {
                        { "AHIBhiChi hi", 3 },
                        { "Ahi hi", 2 },
                        { " hi", 1 },
                        { " hi", 2 },
                        { " hihi", 2 },
                        { " hihihi hihihi hi", 7 },
                        { "Ahi hihihihhi", 5 }
                };
    }
}
