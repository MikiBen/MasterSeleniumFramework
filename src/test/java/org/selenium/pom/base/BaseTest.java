package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

   private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

   @Parameters("browser")
   @BeforeMethod

    public void startDriver(@Optional  String browser){
       // browser = System.getProperty("browser", browser); //testNg
      if(browser ==null) browser = "CHROME";
        setDriver(new DriverManger().initializeDriver(browser));
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + " DRIVER : " + getDriver());
    }

   @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(100);
        driver.get().quit();
    }


}
