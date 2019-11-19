import io.cucumber.core.cli.Main;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/test/resources"},
    plugin = {"html:target/reports/cucumberReport", "CukesTeardown"}
    //tags = { @fast } //see docs https://cucumber.io/docs/cucumber/api/#tags
)
public class RunCukesTest {

  /*
  //run in parallel w/junit
  @Test
  public void test() {
    String[] params = new String[] { "-p", "timeline:target/reports/cucumber-parallel-report",
        "-p","html:target/reports/bdd", "-p","CukesTeardown","-p","pretty",
        "-g", "src/test/stepdefs", "src/test/resources/", "--threads", "1",
        "-t","@sad, @glance"
    };
    Main.run(params, Thread.currentThread().getContextClassLoader());
  }
   */
}
