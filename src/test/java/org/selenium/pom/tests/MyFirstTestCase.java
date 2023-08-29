package org.selenium.pom.tests;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.objects.BillingAddress;
import org.selenium.pom.objects.Product;
import org.selenium.pom.pages.CartPage;
import org.selenium.pom.pages.CheckOutPage;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StorePage;
import org.selenium.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyFirstTestCase extends BaseTest {
    @Test
     public void guestCheckOutUsingDirectBankTransfer() throws IOException, InterruptedException {

        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);


        //BillingAddress billingAddress = new BillingAddress("demo", "Demo2","San","San" , "94188", "mm@pp.pl");
           /* setFirstName("demo").
            setLastName("Demo2").
            setAddressLineOne("San").
            setCity("San").
            setPostalCode("94188").
            setEmail("mm@pp.pl");
*/
        StorePage storePage = new HomePage(getDriver()).
                load().
                navigateToStoreUsingMenu().
       // storePage.isLoaded();
        search(searchFor);

       /*
        StorePage storePage = homePage.navigateToStoreUsingMenu();

        storePage.
                enterTextInSearchField("Blue").
                clickSearchButton();
*/
       // storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

        storePage.clickAddToCartBtn(product.getName());
       //Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();
       // cartPage.idLoaded();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckOutPage checkOutPage = cartPage.
                checkout().
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
               // enterFirstName("demo").
              //  enterLastName("user").
              //  enterAddressLineOne("San Francisco").
             //   enterBillingCity("San Francisco").
             //   enterBillingPostCode("94188").
             //   enterBillingEmail("miki@ww.pp").
                clickPlaceOrder();
       // Thread.sleep(3000);
        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");

    }
/*
    @Test
    public void loginAndCheckOutUsingDirectBankTransfer() throws InterruptedException {

        driver.get("https://askomdch.com/");

        HomePage homePage = new HomePage(driver);
        StorePage storePage = homePage.navigateToStoreUsingMenu();

        storePage.
                enterTextInSearchField("Blue").
                clickSearchButton();

        // storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “Blue”");

        storePage.clickAddToCartBtn("Blue Shoes");
        Thread.sleep(5000);
        CartPage cartPage = storePage.clickViewCart();

        Assert.assertEquals(cartPage.getProductName(), "Blue Shoes");
        CheckOutPage checkOutPgae = cartPage.checkout();

        checkOutPgae.clickToLoginLink();
        Thread.sleep(5000);

        checkOutPgae.
                login("demouser2", "demopwd").
                enterFirstName("demo").
                enterLastName("user").
                enterAddressLineOne("San Francisco").
                enterBillingCity("San Francisco").
                enterBillingPostCode("94188").
                enterBillingEmail("miki@ww.pp").
                clickPlaceOrder();
        Thread.sleep(5000);
        Assert.assertEquals(checkOutPgae.getNotice(), "Thank you. Your order has been received.");

    }

 */

    @Test
    public void guestCheckOutUsingDirectBankTransfer2() throws IOException, InterruptedException {

        String searchFor = "Blue";
        BillingAddress billingAddress = JacksonUtils.deserializeJson("myBillingAddress.json", BillingAddress.class);
        Product product = new Product(1215);


        //BillingAddress billingAddress = new BillingAddress("demo", "Demo2","San","San" , "94188", "mm@pp.pl");
           /* setFirstName("demo").
            setLastName("Demo2").
            setAddressLineOne("San").
            setCity("San").
            setPostalCode("94188").
            setEmail("mm@pp.pl");
*/
        StorePage storePage = new HomePage(getDriver()).
                load().
                navigateToStoreUsingMenu().
                // storePage.isLoaded();
                        search(searchFor);

       /*
        StorePage storePage = homePage.navigateToStoreUsingMenu();

        storePage.
                enterTextInSearchField("Blue").
                clickSearchButton();
*/
        // storePage.search("Blue");
        Assert.assertEquals(storePage.getTitle(), "Search results: “" + searchFor + "”");

        storePage.clickAddToCartBtn(product.getName());
        //Thread.sleep(3000);
        CartPage cartPage = storePage.clickViewCart();
        // cartPage.idLoaded();
        Assert.assertEquals(cartPage.getProductName(), product.getName());

        CheckOutPage checkOutPage = cartPage.
                checkout().
                setBillingAddress(billingAddress).
                selectDirectBankTransfer().
                // enterFirstName("demo").
                //  enterLastName("user").
                //  enterAddressLineOne("San Francisco").
                //   enterBillingCity("San Francisco").
                //   enterBillingPostCode("94188").
                //   enterBillingEmail("miki@ww.pp").
                        clickPlaceOrder();
        // Thread.sleep(3000);
        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");

    }
}
