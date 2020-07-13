package utils;

import static io.github.sridharbandi.util.Standard.SECTION508;
import static io.github.sridharbandi.util.Standard.WCAG2A;
import static io.github.sridharbandi.util.Standard.WCAG2AA;
import static io.github.sridharbandi.util.Standard.WCAG2AAA;

import io.github.sridharbandi.Accessibility;
import io.github.sridharbandi.AccessibilityRunner;
import org.openqa.selenium.WebDriver;

public class AccessibilityManager {

  private static WebDriver webDriver;
  private static AccessibilityRunner accessibilityRunner;
  private static String accessibilityStandard;


  public AccessibilityManager(){
    webDriver = CukesWebDriverManager.getDriver();
    accessibilityRunner = new AccessibilityRunner(webDriver);
    setAccStandard();
    setAccessibilityPath();
  }

  public static AccessibilityRunner getInstance(){
    return accessibilityRunner;
  }

  public AccessibilityRunner getRunner(){
    return (accessibilityRunner == null)? new AccessibilityRunner(webDriver): accessibilityRunner;
  }

  private void setAccStandard(){
    String stndrd = ConfigFileReader.getProperty("a11y.standard");

    switch (stndrd){
      case "SECTION508" : {
        accessibilityStandard = SECTION508;//new Standard(); //.SECTION508;
      }
      break;
      case "WCAG2A" :{
        accessibilityStandard = WCAG2A;
      }
      break;
      case "WCAG2AA":{
        accessibilityStandard= WCAG2AA;
      }
      break;
      case "WCAG2AAA": {
        accessibilityStandard = WCAG2AAA;
      }
      break;
      default: {
        System.out.println("could not get standard: "+stndrd);
      }
      break;
    }

    Accessibility.STANDARD = accessibilityStandard;
  }

  private void setAccessibilityPath(){
    Accessibility.REPORT_PATH = ConfigFileReader.getProperty("a11y.reports");
  }

}
