package com.enuygun.util;


import java.util.*;
import java.util.concurrent.TimeUnit;

import com.enuygun.Helper.WaitTool;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest {

    private Logger log = Logger.getLogger(BasePage.class);

    private static WebDriverWait webDriverWait = new WebDriverWait(driver, 5);

    protected void fillInputField(By by, String text, int... index) {
        fillInputField(by, text, false, index);
    }

    private void fillInputField(By by, String text, boolean pressEnter, int... index) {
        WebElement element;

        try {
            element = findElement(by, index);
            if (element.isEnabled()) {
                HighlightElement(element);
                element.clear();
                element.sendKeys(text);

                if (pressEnter) {
                    element.sendKeys(Keys.ENTER);
                }
            }
        } catch (NullPointerException e) {
            Assert.assertTrue("Nullpointer Exception for " + by, false);
        }
    }

    protected WebElement findElement(By by, int... index) {
        WebElement el = null;
        if (index.length == 0) {
            try {
                el = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(by));
            } catch (Exception e) {
                return null;
            }
        } else if (index[0] >= 0) {
            try {
                el = webDriverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by)).get(index[0]);
            } catch (Exception e) {
                return null;
            }
        }
        HighlightElement(el);

        return el;
    }

    private void HighlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
                "color: red; border: 1px dashed red;");
    }


    private void logger(String message) {
        if (message != null) {
            log.info(message);
        }
    }

    protected void clickObject(By by, String message, int... index) {
        WaitTool.waitForElementClickable(driver, by, 5);
        WebElement element = findElement(by, index);
        HighlightElement(element);
        element.click();
        logger("--------------------------->" + message + "         ");
    }

    protected boolean isElementDisplayed(By by, int... index) {
        boolean found = false;

        try {
            if (findElement(by, index) != null)
                found = true;
        } catch (NullPointerException e) {
            found = false;
        }

        return found;
    }


    public WebElement waitForElement(int seconds, By elementBy) {
        WebDriverWait wait = new WebDriverWait(driver, seconds, 1000);
        return wait.until(ExpectedConditions.presenceOfElementLocated(elementBy));
    }


    public String getText(By by, int... index) {
        HighlightElement(findElement(by));
        return findElement(by, index).getText();
    }


}
