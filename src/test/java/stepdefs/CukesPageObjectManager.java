package stepdefs;

import org.openqa.selenium.remote.RemoteWebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RegisterPage;

public class CukesPageObjectManager {

  private final RemoteWebDriver driver;
  private MainPage mainPage;
  private LoginPage loginPage;
  private RegisterPage registerPage;

  public CukesPageObjectManager(final RemoteWebDriver driver) {
    this.driver = driver;
  }

  //get new instance of Main Page. use same pattern for other pages
  public MainPage getMainPage(){
    return (mainPage == null) ? mainPage = new MainPage(driver) : mainPage;
  }

  public LoginPage getLoginPage(){
    return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
  }

  public RegisterPage registerPage(){
    return (registerPage == null) ? registerPage = new RegisterPage(driver) : registerPage;
  }
}
