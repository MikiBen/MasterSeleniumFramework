package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;
import org.selenium.pom.objects.BillingAddress;

public class CheckOutPage extends BasePage   {

    private final By firstNameFld = By.id("billing_first_name");
    private final By lastNameFld = By.id("billing_last_name");
    private final By addressLineOneFld = By.id("billing_address_1");
    private final By billingCityFld = By.id("billing_city");
    private final By billingPostCodeFld = By.id("billing_postcode");
    private final By billingEmailFld = By.id("billing_email");
    private final By placeOrderBtn = By.id("place_order");
    private final By successNotice = By.cssSelector(".woocommerce-notice");

    private final By toLogin = By.cssSelector(".showlogin");
    private final By usernameFld = By.id("username");
    private final By passwordFld = By.id("password");
    private final By loginButton = By.cssSelector("button[value='Login']");

    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterFirstName(String txt){
        driver.findElement(firstNameFld).clear();
        driver.findElement(firstNameFld).sendKeys(txt);
        return this;
    }
    public CheckOutPage enterLastName(String txt){
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(txt);
        return this;
    }
    public CheckOutPage enterAddressLineOne(String txt){
        driver.findElement(addressLineOneFld).clear();
        driver.findElement(addressLineOneFld).sendKeys(txt);
        return this;
    }
    public CheckOutPage enterBillingCity(String txt){
        driver.findElement(billingCityFld).clear();
        driver.findElement(billingCityFld).sendKeys(txt);
        return this;
    }
    public CheckOutPage enterBillingPostCode(String txt){
        driver.findElement(billingPostCodeFld).clear();
        driver.findElement(billingPostCodeFld).sendKeys(txt);
        return this;
    }
    public CheckOutPage enterBillingEmail(String txt){
        driver.findElement(billingEmailFld).clear();
        driver.findElement(billingEmailFld).sendKeys(txt);
        return this;
    }
    public CheckOutPage clickPlaceOrder(){
        driver.findElement(placeOrderBtn).click();
        return this;
    }

    public String getNotice(){
       return driver.findElement(successNotice).getText();

    }

    public CheckOutPage clickToLoginLink() {
        driver.findElement(toLogin).click();
        return this;
    }
    public CheckOutPage clickLoginBtn() {
        driver.findElement(loginButton).click();
        return this;
    }

    public CheckOutPage enterUserName(String login) {
        driver.findElement(usernameFld).sendKeys(login);
        return this;
    }
    public CheckOutPage enterPassword(String password) {
        driver.findElement(usernameFld).sendKeys(password);
        return this;
    }

    public CheckOutPage login(String login, String password) {
        return  enterUserName(login).
                enterPassword(password).
                clickLoginBtn();

    }

    public CheckOutPage setBillingAddress(BillingAddress billingAddress){
        return  enterFirstName(billingAddress.getFirstName()).
                enterLastName(billingAddress.getLastName()).
                enterAddressLineOne(billingAddress.getAddressLineOne()).
                enterBillingCity(billingAddress.getCity()).
                enterBillingPostCode(billingAddress.getPostalCode()).
                enterBillingEmail(billingAddress.getEmail());

    }
}
