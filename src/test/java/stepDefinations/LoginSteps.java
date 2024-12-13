package stepDefinations;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.*;

public class LoginSteps {
    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        WebDriver driver = Hooks.getDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters valid credentials {string} and {string}")
    public void the_user_enters_valid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @When("the user enters invalid credentials {string} and {string}")
    public void the_user_enters_invalid_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @When("the user enters blank credentials")
    public void the_user_enters_blank_credentials() {
        loginPage.clickLogin();
    }

    @Then("the user should be redirected to the Products page")
    public void the_user_should_be_redirected_to_the_products_page() {
        assertTrue(loginPage.isOnProductsPage(), "User not redirected to the Products page.");
    }

    @Then("the user should see an error message {string}")
    public void the_user_should_see_an_error_message(String expectedMessage) {
        assertEquals(expectedMessage, loginPage.getErrorMessage(), "Error message mismatch.");
    }
}