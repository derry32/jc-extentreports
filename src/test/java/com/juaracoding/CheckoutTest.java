package com.juaracoding;

import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import com.juaracoding.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutTest {
    private WebDriver driver;

    private LoginPage loginPage = new LoginPage();
    private ProductPage productPage = new ProductPage();
    private CartPage cartPage = new CartPage();
    private CheckoutPage checkoutPage = new CheckoutPage();

    public CheckoutTest(){
        driver = Hooks.driver;
    }

    //successful

    @Given("the user is logged in with standard_user and secret_sauce")
    public void the_user_is_logged_in_with_standard_user_and_secret_sauce() {
        driver.get(Constants.URL);
        loginPage.enterUsername("standard_user");
        delay(2);
        loginPage.enterPassword("secret_sauce");
        delay(2);
        loginPage.clickLoginButton();

    }

    @When("the user adds two products to cart")
    public void the_user_adds_two_products_to_cart() {
        productPage.AddBikeLightToCart();
        delay(2);
        productPage.AddBoltTshirtToCart();
        delay(2);
        productPage.goToCart();
        delay(3);

    }

    @And("the user goes to the cart and proceeds to checkout")
    public void the_user_goes_to_the_cart_and_proceeds_to_checkout() {
        cartPage.proceedToCheckout();
    }

    @Then("the user enters John as first name, Doe as last name, and 12345 as postal code")
    public void the_user_enters_John_as_first_name_Doe_as_last_name_and_12345_as_postal_code() {
        checkoutPage.enterFirstName("John");
        delay(1);
        checkoutPage.enterLastName("Doe");
        delay(2);
        checkoutPage.enterPostCode("12345");
        delay(3);
    }

    @And("the user clicks continue")
    public void the_user_clicks_continue() {
        delay(3);
        checkoutPage.clickContinueBtn();
    }

    @Then("the user should see the checkout overview page")
    public void the_user_should_see_the_checkout_overview_page() {
        delay(2);
        Assert.assertEquals(checkoutPage.getTxtDashboard(), "Checkout: Overview");
    }

    //unsuccessful

    @When("the user remove before adds two products to cart")
    public void the_user_remove_before_adds_two_products_to_cart() {
        productPage.RemoveBikeLightToCart();
        delay(2);
        productPage.RemoveBoltTshirtToCart();
        delay(2);
        productPage.AddBikeLightToCart();
        delay(2);
        productPage.AddBoltTshirtToCart();
        delay(2);
        productPage.goToCart();
        delay(3);

    }


    @When("the user enters empty the first name, Doe as last name, and 12345 as postal code")
    public void the_user_enters_empty_the_first_name_Doe_as_last_name_and_12345_as_postal_code() {
        checkoutPage.enterFirstName("");
        delay(1);
        checkoutPage.enterLastName("Doe");
        delay(2);
        checkoutPage.enterPostCode("12345");
        delay(3);
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message(){
        delay(2);
        Assert.assertEquals(checkoutPage.getErrorMessage(),"Error: First Name is required");
    }

    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
