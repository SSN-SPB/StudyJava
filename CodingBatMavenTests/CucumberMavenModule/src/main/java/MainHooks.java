import com.codeborne.selenide.Configuration;
import io.cucumber.java.Before;

public class MainHooks {
    @Before
    public void prepare(){
        Configuration.baseUrl = "https://www.google.com";
        Configuration.timeout = 10000;
    }
}
