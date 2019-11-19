package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigFileReader;
import utils.FileReaderManager;

public class LoginPage extends PageObject {

  private static ConfigFileReader reader = FileReaderManager.getInstance().getConfigReader();
  private static String url;

  public LoginPage(RemoteWebDriver driver) {
    super(driver);
    String maybeUrl = reader.getProperty("url");
    if (maybeUrl != null){
      url = maybeUrl;
    } else {
      System.err.println("unable to get url: "+maybeUrl);
    }

    driver.get(url);
    //use pagefactory to get page webelements
    PageFactory.initElements(driver, this);
  }

  @FindBy(how = How.ID, using = "")
  public WebElement search;

  public String getTitle(){
    return driver.getTitle();
  }
}
