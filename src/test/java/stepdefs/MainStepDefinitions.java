package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.MainPage;

public class MainStepDefinitions {

  RemoteWebDriver driver;
  private MainPage mainPage;
  private CukesTestContext testContext;
  //private AccessibilityRunner a11yRunner;

  public MainStepDefinitions(CukesTestContext context) {
    testContext = context;
    mainPage = testContext.getCukesPageObjectManager().getMainPage();
    //a11yRunner = testContext.getAccessibilityManager().getRunner();
  }

  @Given("^I have a configured Cucumber")
  public void i_have_a_configured_Cucumber() throws Exception {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
    Assert.assertNotEquals("not same","hello", mainPage.getTitle());
    //a11yRunner.execute();
  }

  @When("^I run it in my IDE$")
  public void i_run_it_in_my_IDE() throws Exception {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
  }

  @Then("^I will be able to run steps$")
  public void i_will_be_able_to_run_steps() throws Exception {
    // Write code here that turns the phrase above into concrete actions
    //throw new PendingException();
  }

}
