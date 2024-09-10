package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage = new LoginPage();

    public LoginTest(){
        driver = Hooks.driver;
    }

    //successful
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        driver.get(Constants.URL);
    }

    @When("User enters valid username and password for login")
    public void user_Enters_Valid_Username_And_Password_For_Login() {
        loginPage.enterUsername("standard_user");
        delay(1);
        loginPage.enterPassword("secret_sauce");
        delay(2);
    }

    @And("User clicks login button for login")
    public void user_Clicks_Login_Button_On_Login_Page() {
        loginPage.clickLoginButton();
    }

    @Then("the user should see the products page")
    public void the_user_should_see_the_products_page(){
        delay(2);
        Assert.assertEquals(loginPage.getTxtDashboard(), "Products");
    }

    //unsuccessful
    @When("User enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {
        loginPage.enterUsername("invalid_user");
        delay(1);
        loginPage.enterPassword("secret_sauce");
        delay(2);
    }

    @When("User enters valid username and invalid password for login")
    public void user_enters_valid_username_and_invalid_password_for_login() {
        loginPage.enterUsername("standard_user");
        delay(1);
        loginPage.enterPassword("wrong_password");
        delay(2);
    }

    @When("User enters empty username and empty password for login")
    public void user_enters_empty_username_and_empty_password_for_login() {
        loginPage.enterUsername("");
        delay(1);
        loginPage.enterPassword("");
        delay(2);
    }

    @Then("User should see an error message for login")
    public void user_should_see_an_error_message_for_login() {
        loginPage.getErrorMessage();
    }

    @Then("User should be redirected to the product page for login")
    public void user_Should_Be_Redirected_To_The_Product_Page_for_login() {
        delay(1);
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"));
    }

    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
