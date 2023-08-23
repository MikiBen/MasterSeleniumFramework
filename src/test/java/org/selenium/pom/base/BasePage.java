package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;

import java.util.SplittableRandom;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public  void load(String endPoint){
        driver.get("https://askomdch.com/" + endPoint);
    }
}
