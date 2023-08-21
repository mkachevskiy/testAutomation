package jenkins.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagePage extends BasePage {

  @FindBy(xpath = "//*[contains(text(),'Users')]")
  WebElement usersButton;

  public ManagePage(WebDriver driver) {
    super(driver);
  }

  public UsersPage selectUsers() {
    usersButton.click();
    return new UsersPage(driver);
  }

}
