package jenkins.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {

  @Getter
  @FindBy(xpath = "//*[contains(@class,\"alert alert-danger\")]")
  WebElement validation;

  @FindBy(id = "j_username")
  WebElement usernameInput;
  @FindBy(name = "j_password")
  WebElement passwordInput;
  @FindBy(id = "remember_me")
  WebElement keepCheckBox;
  @FindBy(name = "Submit")
  WebElement submitButton;

  public LoginPage(WebDriver driver) {
    super(driver);
    driver.get("http://localhost:8080/login");
  }

  public MainPage loginToSystem(String name, String pass) {
    usernameInput.sendKeys(name);
    passwordInput.sendKeys(pass);
    submitButton.click();
    return new MainPage(driver);
  }

}
