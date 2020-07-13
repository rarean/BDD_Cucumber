package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigFileReader;

public class RegisterPage  extends PageObject{

    private static String url;

    public RegisterPage(RemoteWebDriver driver) {
        super(driver);
        String maybeUrl = ConfigFileReader.getProperty("baseUrl") + "/register";
        url = maybeUrl;

        driver.get(url);
        //use pagefactory to get page webelements
        PageFactory.initElements(driver, this);
    }
}
