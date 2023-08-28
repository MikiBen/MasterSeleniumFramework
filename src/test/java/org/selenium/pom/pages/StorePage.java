package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class StorePage extends BasePage {

    private final By searchFld = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.cssSelector("button[value='Search']");
    private final By title = By.cssSelector(".woocommerce-products-header__title.page-title");
    private final By viewCartLink = By.cssSelector("a[title='View cart']");

    public StorePage(WebDriver driver){
        super(driver);
    }

    public StorePage enterTextInSearchField(String txt){
        driver.findElement(searchFld).sendKeys(txt);
        return this;
    }

    public boolean isLoaded(){
        return wait.until(ExpectedConditions.urlContains("/store"));
    }

    public StorePage search(String txt){
        driver.findElement(searchFld).sendKeys(txt);
        driver.findElement(searchButton).click();
        return this;
    }

    public StorePage clickSearchButton(){
        driver.findElement(searchButton).click();
        return this;
    }

    public String getTitle(){
        return driver.findElement(title).getText();
    }

    private By getAddToCartBtn(String productName){
        return By.cssSelector("a[aria-label='Add “" + productName + "” to your cart']");

    }
    public StorePage clickAddToCartBtn(String productName){
        By addToCartBrn = getAddToCartBtn(productName);
        driver.findElement(addToCartBrn).click();
        return this;
    }
    public CartPage clickViewCart(){

        wait.until(ExpectedConditions.elementToBeClickable(viewCartLink)).click();
        //driver.findElement(viewCartLink).click();
       return new CartPage(driver);
    }

}

