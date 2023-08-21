package utils;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ExtensionContext.Namespace;
import org.openqa.selenium.WebDriver;


public class SeleniumExtension implements BeforeAllCallback, AfterAllCallback {

  private final TestUtils testUtils = new TestUtils();
  public static final String KEY = "Driver";

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    testUtils.cleanReportFolder();

    WebDriver driver = testUtils.initWebDriver();
    context.getStore(Namespace.create(SeleniumExtension.class)).put(KEY, driver);
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    WebDriver driver = context.getStore(Namespace.create(SeleniumExtension.class))
        .get(KEY, WebDriver.class);
    driver.close();
  }
}
