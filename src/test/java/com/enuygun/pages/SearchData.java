package com.enuygun.pages;

import com.enuygun.util.BasePage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchData extends BasePage {

    @Step("Belirlenen tarihler arasında uçak bileti aramasının yapılması")
    public void searchDataValue() {
        clickObject(By.id("OriginInput"), "Kalkış yerini seçilmesi");
        fillInputField(By.id("OriginInput"), "İstanbul");
        driver.findElement(By.id("OriginInput")).sendKeys(Keys.DOWN, Keys.ENTER);

        clickObject(By.id("DestinationInput"), "Varış yerinin seçilmesi");
        fillInputField(By.id("DestinationInput"), "Ankara");
        driver.findElement(By.id("DestinationInput")).sendKeys(Keys.DOWN, Keys.ENTER);
        clickObject(By.id("DepartureDate"), "Ara butonuna tıkla.");

        clickObject(By.xpath("//*[@aria-label='Cuma, 5 Kasım 2021']"), "Tarihe tıkla.");
        clickObject(By.xpath("//*[@class='primary-btn block']"), "Ucuz bilet bula tıkla.");

        waitForElement(10, By.xpath("(//*[@class='action-select-btn tr btn btn-outline-success btn-sm'])[1]"));

        clickObject(By.xpath("(//*[@class='action-select-btn tr btn btn-outline-success btn-sm'])[1]"), "Seçe tıkla.");


    }

    @Step("Kullanıcı Bilgilerinin Girilmesi")
    public void isSetData() {

        waitForElement(5, By.id("contact_email"));
        fillInputField(By.id("contact_email"), "cagataycagli@yandex.com");
        fillInputField(By.id("contact_cellphone"), "5555555545");
        fillInputField(By.id("firstName_0"), "Çağatay");
        fillInputField(By.id("lastName_0"), "Çalı");


        WebElement day_dropdown = driver.findElement(By.id("birthDateDay_0"));
        Select day = new Select(day_dropdown);
        day.selectByVisibleText("01");
        WebElement month_dropdown = driver.findElement(By.id("birthDateMonth_0"));
        Select month = new Select(month_dropdown);
        month.selectByVisibleText("Ocak");
        WebElement year_dropdown = driver.findElement(By.id("birthDateYear_0"));
        Select year = new Select(year_dropdown);
        year.selectByVisibleText("1991");

        //fillInputField(By.id("publicId_0"), "12345678910");

        clickObject(By.xpath("//*[@class=' btn btn-success btn-lg tr  js-reservation-btn']"), "Ödemeye İlerle Tıklandı.");

        waitForElement(5, By.id("cardnumber"));


        Assert.assertTrue("Giriş Yapılamadı.", isElementDisplayed(By.id("cardnumber")));


    }
}
