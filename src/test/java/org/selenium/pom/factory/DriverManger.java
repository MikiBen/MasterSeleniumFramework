package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.selenium.pom.constants.DriverType;

public class DriverManger {

    public WebDriver initializeDriver(String browser){
        WebDriver driver;
        String rowser;
        browser = System.getProperty("browser", browser);
       // localBrowser = browser;
        switch (DriverType.valueOf(browser)){
            case CHROME:
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                 driver = new ChromeDriver();
                break;
            case EDGE:
                WebDriverManager.edgedriver().cachePath("Drivers").setup();
                 driver = new EdgeDriver();
                 break;
            case FIREFOX:
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                 driver = new FirefoxDriver();
                 break;
            default:
                throw new IllegalStateException("Invalid browser : " + browser);
        }

        //WebDriverManager.chromedriver().setup();


        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        return driver;
    }
}
