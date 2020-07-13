package utils;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CukesWebDriverManager {
  private static RemoteWebDriver driver = null;
  
  public CukesWebDriverManager() {
    FileReaderManager.getInstance().getConfigReader();
  }

  public static RemoteWebDriver createDriver() {

    try {
      final DesiredCapabilities capabilities = new DesiredCapabilities();
      final LoggingPreferences logPrefs = new LoggingPreferences();
      logPrefs.enable(LogType.BROWSER, Level.ALL);

      switch (ConfigFileReader.getProperty("webdriver.type")) {
        case "CHROME": {
          io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
          //System.setProperty("webdriver.chrome.driver", "/mnt/c/selenium/chromedriver_win32/chromedriver.exe");
          ChromeOptions options = new ChromeOptions();
          //options.addArguments("enable-automation");
          options.addArguments("--start-maximized");
          options.addArguments("--no-sandbox");
          options.addArguments("--disable-dev-shm-usage");
          //options.setExperimentalOptions("useAutomationExtension", false);
          options.setCapability("goog:loggingPrefs", logPrefs);

          //ensure driver is threadsafe
          synchronized (RemoteWebDriver.class) {
            options.merge(capabilities);
            driver = new ChromeDriver(options);
          }
          break;
        }
        case "FIREFOX": {
          //setup for bonigarcia WebDriverManager
          FirefoxDriverManager.firefoxdriver().setup();
          capabilities.setBrowserName("firefox");
          capabilities.setCapability("acceptInsecureCerts", true);

          FirefoxOptions firefoxOptions = new FirefoxOptions();
          firefoxOptions.setCapability("goog:loggingPrefs", logPrefs);
          //ensure driver is threadsafe
          synchronized (RemoteWebDriver.class) {
            firefoxOptions.merge(capabilities);
            driver = new FirefoxDriver(firefoxOptions);
          }
          break;
        }
        default: {
          System.err.println(
              "the Web driver was not initialized; type: " + ConfigFileReader.getProperty("webdriver.type"));
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    synchronized(RemoteWebDriver.class){
      return driver;
    }

  }

  public static RemoteWebDriver getDriver() {
    //TODO: add things like testwatcher, logging etc by default
    //ensure driver is threadsafe
    synchronized (RemoteWebDriver.class) {
      if(driver == null) driver = createDriver();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().implicitlyWait(WaitTimeManager.getImplicitlyWait(), TimeUnit.SECONDS);
      driver.manage().window().maximize();
      return driver;
    }
  }

  public static void closeDriver(){
    synchronized (RemoteWebDriver.class) {
      if (driver != null) {
        driver.close();
        driver.quit();
      } else {
        System.err.println("driver is null");
      }

    }
  }



}
