package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigFileReader;

public class MainPage extends PageObject {

  private static String url;

  public MainPage(final RemoteWebDriver driver) {
    super(driver);
    final String maybeUrl = ConfigFileReader.getProperty("baseUrl");
    if (maybeUrl != null){
      url = maybeUrl;
    } else {
      System.err.println("unable to get url: "+maybeUrl);
    }

    driver.get(url);
    //use pagefactory to get page webelements
    PageFactory.initElements(driver, this);
  }

  @FindBy(how = How.CLASS_NAME, using = "main-header")
  public WebElement mainHeader;

  public String getTitle(){
    return driver.getTitle();
  }
}
