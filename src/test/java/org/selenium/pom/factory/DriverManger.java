package org.selenium.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManger {

    public WebDriver initializeDriver(){
        WebDriver driver;

        String browser = System.getProperty("browser");
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                 driver = new ChromeDriver();
                break;
            case "Edge":
                WebDriverManager.edgedriver().cachePath("Drivers").setup();
                 driver = new EdgeDriver();
                 break;
            case "Firefox":
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
