package org.selenium.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void load(String endPoint) {
        driver.get("https://askomdch.com/" + endPoint);
    }

    public void wairForIverlaysToDisappear(By overlay) {
        List<WebElement> oberlays = driver.findElements(overlay);
        if (oberlays.size() > 0) {
            wait.until(
                    ExpectedConditions.invisibilityOfAllElements(oberlays)
            );
        }else {
            System.out.println("OVERLAY NOT FOUND");
        }
    }

    public WebElement waitForElementToBeVisible(By element){
        return  wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
