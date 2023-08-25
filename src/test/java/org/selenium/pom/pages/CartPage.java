package org.selenium.pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.selenium.pom.base.BasePage;

public class CartPage extends BasePage {
  /*  private final By productName = By.cssSelector("td[class='product-name'] a");
    private final By checkoutBtn = By.cssSelector(".checkout-button");
    private final By cartHeading = By.cssSelector(".has-text-align-center");
 */
    //PAGE FACTORY
    @FindBy(css = "td[class='product-name'] a")
    private WebElement productName;

    @FindBy(css = ".checkout-button")
    private WebElement checkoutBtn;

    @FindBy(css = ".has-text-align-center")
    private WebElement cartHeading;

  public CartPage(WebDriver driver) {
        super(driver);
      PageFactory.initElements(driver, this);
    }
/*
    public Boolean isLoaded(){
       // return wait.until(ExpectedConditions.textToBe(cartHeading, "Cart"));
        return wait.until(ExpectedConditions.textToBe(cartHeading, "Cart"));
    }
*/
    public String getProductName(){
        //return wait.until(ExpectedConditions.visibilityOfElementLocated(productName)).getText();
//Page factory
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();


       // return driver.findElement(productName).getText();
    }

    public CheckOutPage checkout(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
        return new CheckOutPage(driver);
    }
}
