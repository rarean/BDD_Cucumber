package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.sridharbandi.AccessibilityRunner;
import org.junit.Assert;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.LoginPage;
import pages.MainPage;

public class LoginStepdefs {

    RemoteWebDriver driver;
    private final MainPage mainPage;
    private final LoginPage loginPage;
    private final CukesTestContext testContext;
    //private final AccessibilityRunner a11yRunner;

    public LoginStepdefs(CukesTestContext context) {
        testContext = context;
        mainPage = testContext.getCukesPageObjectManager().getMainPage();
        loginPage = testContext.getCukesPageObjectManager().getLoginPage();
        //a11yRunner = testContext.getAccessibilityManager().getRunner();
    }

    @Given("^I am on the longin page")
    public void IamOnTheLoginPage() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        Assert.assertEquals("Login", loginPage.mainHeader.getText());
        Assert.assertNotEquals("not same","hello", loginPage.getTitle());
        //a11yRunner.execute();
    }

    @When("I click new user button")
    public void iClickNewUserButton() throws Exception {
        Assert.assertTrue(loginPage.newUserButton.isDisplayed());
        loginPage.newUserButton.click();
    }

    @Then("I am directed to the registration page")
    public void iAmDirectedToTheRegistrationPage() {
        //do some validation
    }
}
