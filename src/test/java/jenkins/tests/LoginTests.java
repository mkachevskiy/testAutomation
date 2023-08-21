package jenkins.tests;

import static utils.TestUtils.jenkinsPassword;
import static utils.TestUtils.jenkinsUser;

import java.util.stream.Stream;
import jenkins.pages.LoginPage;
import jenkins.pages.MainPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.WebSelenium;
import utils.TestUtils;

@WebSelenium
public class LoginTests {

  @Test
  public void successfulLogin() {
    LoginPage loginPage = new LoginPage(TestUtils.driver);
    MainPage mainPage = loginPage.loginToSystem(jenkinsUser, jenkinsPassword);
    Assertions.assertTrue(mainPage.isWelcomeHeaderPresent());
  }

  private static Stream<Arguments> validationInvalidData() {
    return Stream.of(Arguments.of("jenkins-user", ""), Arguments.of("wrongUserName", "jenkins"));
  }

  @ParameterizedTest
  @MethodSource("validationInvalidData")
  public void loginValidation(String userName, String password) {
    LoginPage loginPage = new LoginPage(TestUtils.driver);
    loginPage.loginToSystem(userName, password);
    Assertions.assertTrue(loginPage.getValidation().isDisplayed());
  }
}
