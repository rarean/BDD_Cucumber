package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigFileReader;
import utils.FileReaderManager;

public class RegisterPage  extends PageObject{

    private static ConfigFileReader reader = FileReaderManager.getInstance().getConfigReader();
    private static String url;

    public RegisterPage(RemoteWebDriver driver) {
        super(driver);
        String maybeUrl = reader.getProperty("baseUrl")+"/register";
        if (maybeUrl != null){
            url = maybeUrl;
        } else {
            System.err.println("unable to get url: "+maybeUrl);
        }

        driver.get(url);
        //use pagefactory to get page webelements
        PageFactory.initElements(driver, this);
    }
}
