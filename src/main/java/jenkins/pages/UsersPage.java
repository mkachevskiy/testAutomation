package jenkins.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage extends BasePage {

  @FindBy(className = "jenkins-button jenkins-button--primary")
  WebElement createButton;

  @FindBy(id = "people")
  WebElement peopleTable;

  public UsersPage(WebDriver driver) {
    super(driver);
  }

  public CreateUserPage createUser() {
    createButton.click();
    return new CreateUserPage(driver);
  }


}
