package com.juaracoding;

import com.juaracoding.pages.LoginPage;
import com.juaracoding.pages.ProductPage;
import com.juaracoding.utils.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductTest {
    private WebDriver driver;
    private LoginPage loginPage = new LoginPage();
    private ProductPage productPage = new ProductPage();

    public ProductTest(){
        driver = Hooks.driver;
    }

    @Given("User is on login page for product")
    public void user_Is_On_Login_Page_for_product() {
        driver.get(Constants.URL);
    }

    @When("User enters valid username and password for product")
    public void user_Enters_Valid_Username_And_Password_For_Product() {
        loginPage.enterUsername("standard_user");
        delay(2);
        loginPage.enterPassword("secret_sauce");
    }

    @And("User clicks login button for product")
    public void user_Clicks_Login_Button_On_Product_Page() {
        delay(1);
        loginPage.clickLoginButton();
    }

    @Then("User should be redirected to the product page")
    public void user_Should_Be_Redirected_To_The_Product_Page_For_Product_Steps() {
        delay(1);
        Assert.assertEquals(productPage.getTxtDashboard(), "Products");
    }

    @When("User adds two products to the cart")
    public void user_adds_two_products_to_the_cart() {
        delay(1);
        productPage.RemoveBikeLightToCart();
        delay(1);
        productPage.RemoveBoltTshirtToCart();
        delay(1);
        productPage.AddBikeLightToCart();
        delay(1);
        productPage.AddBoltTshirtToCart();
    }

    @And("User goes to the cart")
    public void user_Goes_To_The_Cart() {
        delay(1);
        productPage.goToCart();
    }

    @Then("User should see two products in the cart")
    public void user_Should_See_Two_Products_In_The_Cart() {
        delay(1);
        String cartItemCount = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText();
        Assert.assertEquals("2", cartItemCount);
    }

    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
