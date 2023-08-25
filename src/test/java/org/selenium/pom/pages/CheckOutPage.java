package org.selenium.pom.pages;

import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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


    private final By overlay = By.cssSelector(".blockUI.blockOverlay");

    private final By countryDropDown = By.id("billing_country");
    private final By stateDropDown = By.id("billing_state");

    private final By directBankTransferRadioBtn = By.id("payment_method_bacs");
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    public CheckOutPage enterFirstName(String txt){
        WebElement e = waitForElementToBeVisible(firstNameFld);
        e.clear();
        e.sendKeys(txt);
       // driver.findElement(firstNameFld).clear();
       // driver.findElement(firstNameFld).sendKeys(txt);
        return this;
    }
    public CheckOutPage enterLastName(String txt){
        driver.findElement(lastNameFld).clear();
        driver.findElement(lastNameFld).sendKeys(txt);
        return this;
    }

    public CheckOutPage selectCountry(String countryName){
        Select select = new Select(driver.findElement(countryDropDown));
        select.selectByVisibleText(countryName);
        return this;
    }

    public CheckOutPage selectState(String stateName){
        Select select = new Select(driver.findElement(stateDropDown));
        select.selectByVisibleText(stateName);
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
        wairForIverlaysToDisappear(overlay);
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
        driver.findElement(passwordFld).sendKeys(password);
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
                selectCountry(billingAddress.getCountry()).
                enterAddressLineOne(billingAddress.getAddressLineOne()).
                enterBillingCity(billingAddress.getCity()).
                selectState(billingAddress.getState()).
                enterBillingPostCode(billingAddress.getPostalCode()).
                enterBillingEmail(billingAddress.getEmail());

    }

    public CheckOutPage selectDirectBankTransfer(){
        WebElement e = wait.until(ExpectedConditions.elementToBeClickable(directBankTransferRadioBtn));
        if(!e.isSelected()){
            e.click();
        }
        return this;
    }

}
