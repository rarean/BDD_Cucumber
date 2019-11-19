package pages;

import org.openqa.selenium.remote.RemoteWebDriver;

public abstract class PageObject {

  protected final RemoteWebDriver driver;

  protected PageObject(RemoteWebDriver driver) {
    this.driver = driver;
  }


}
