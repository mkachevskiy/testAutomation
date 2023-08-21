package jenkins.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {

  @FindBy(xpath = "//*[contains(text(),'Welcome to Jenkins')]")
  WebElement welcomeHeader;

  @FindBy(xpath = "//*[contains(@class, \"task-link\")]")
  WebElement manageButton;

  public MainPage(WebDriver driver) {
    super(driver);
  }

  public ManagePage openManagePage(){
    manageButton.click();
    return new ManagePage(driver);
  }

  public boolean isWelcomeHeaderPresent() {
    return welcomeHeader.isDisplayed();
  }
}
