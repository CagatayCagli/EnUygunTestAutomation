package com.enuygun.Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitTool {

    public static final int DEFAULT_WAIT_4_PAGE = 12;


    public static WebElement waitForElementClickable(WebDriver driver,
                                                     final By by, int timeOutInSeconds) {
        WebElement element;
        try {
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);


            WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
            element = wait.until(ExpectedConditions.elementToBeClickable(by));

            driver.manage().timeouts()
                    .implicitlyWait(DEFAULT_WAIT_4_PAGE, TimeUnit.SECONDS);
            return element;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
