package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver driver;

    public ProductPage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']")
    private WebElement removeBikeLight;

    @FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']")
    private WebElement removeBoltTshirt;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement addBikeLight;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement addBoltTshirt;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cartLink;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement txtDashboard;


    public void RemoveBikeLightToCart() {
        removeBikeLight.click();
    }

    public void RemoveBoltTshirtToCart() {
        removeBoltTshirt.click();
    }

    public void AddBikeLightToCart() {
        addBikeLight.click();
    }

    public void AddBoltTshirtToCart() {
        addBoltTshirt.click();
    }

    public void goToCart() {
        cartLink.click();
    }

    public String getTxtDashboard(){
        return txtDashboard.getText();
    }
}
