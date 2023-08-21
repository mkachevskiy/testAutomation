package utils;

import java.io.File;
import java.io.IOException;
import jenkins.tests.LoginTests;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestUtils {

  public static WebDriver driver;
  public static Logger logger;
  public static String jenkinsUrl;
  public static String jenkinsUser;
  public static String jenkinsPassword;

  static {
    logger = LoggerFactory.getLogger(LoginTests.class);
    try {
      System.getProperties().load(ClassLoader.getSystemResourceAsStream("testConfig.properties"));
      jenkinsUrl = System.getProperty("jenkins.url");
      jenkinsUser = System.getProperty("jenkins.login");
      jenkinsPassword = System.getProperty("jenkins.password");

    } catch (IOException e) {
      logger.error("Catch IOException while trying to read properties");
    }
  }

  public WebDriver initWebDriver() {
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--start-maximized");

    driver = new ChromeDriver(options);
    return driver;
  }

  public void cleanReportFolder() {
    try {
      File results = new File("allure-results/");
      FileUtils.cleanDirectory(results);
    } catch (IOException e) {
      logger.error("Catch IOException while trying to clean report folder");
    }
  }

}
