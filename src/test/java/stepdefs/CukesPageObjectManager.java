package stepdefs;

import org.junit.AfterClass;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.LoginPage;

public class CukesPageObjectManager {

  private RemoteWebDriver driver;
  private LoginPage loginPage;


  public CukesPageObjectManager(RemoteWebDriver driver) {
    this.driver = driver;
  }

  //get new instance of loginpage. use same pattern for other pages
  public LoginPage getLoginPage(){
    return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
  }

}
