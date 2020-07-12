import cucumber.api.event.EventHandler;
import cucumber.api.event.EventListener;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestRunFinished;
import utils.AccessibilityManager;
import utils.CukesWebDriverManager;

public class CukesTeardown implements EventListener {

  private EventHandler<TestRunFinished> teardown = event -> {
    CukesWebDriverManager.closeDriver();
    //AccessibilityManager.getInstance().generateHtmlReport();
  };

  @Override
  public void setEventPublisher(EventPublisher publisher) {
    publisher.registerHandlerFor(TestRunFinished.class, teardown);
  }
}
