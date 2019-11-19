package stepdefs;

import io.github.sridharbandi.AccessibilityRunner;
import utils.AccessibilityManager;
import utils.CukesWebDriverManager;

/**
 * used to share state between stepdefs
 * http://www.thinkcode.se/blog/2017/04/01/sharing-state-between-steps-in-cucumberjvm-using-picocontainer
 */
public class CukesTestContext {

  private CukesWebDriverManager webDriverManager;
  private CukesPageObjectManager cukesPageObjectManager;
  private AccessibilityManager accessibilityManager;


  public CukesTestContext(){

    webDriverManager = new CukesWebDriverManager();
    cukesPageObjectManager = new CukesPageObjectManager(webDriverManager.getDriver());
    accessibilityManager = new AccessibilityManager();

  }

  public CukesWebDriverManager getWebDriverManager(){
    return webDriverManager;
  }

  public CukesPageObjectManager getCukesPageObjectManager(){
    return cukesPageObjectManager;
  }
  public AccessibilityManager getAccessibilityManager() {
    return accessibilityManager;
  }


}
