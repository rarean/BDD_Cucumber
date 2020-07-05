package stepdefs;

import org.junit.AfterClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;

public class CukesPageObjectManager {

  private RemoteWebDriver driver;
  private MainPage loginPage;


  public CukesPageObjectManager(RemoteWebDriver driver) {
    this.driver = driver;
  }

  //get new instance of loginpage. use same pattern for other pages
  public MainPage getLoginPage(){
    return (loginPage == null) ? loginPage = new MainPage(driver) : loginPage;
  }

}
