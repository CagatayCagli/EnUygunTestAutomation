package com.enuygun.pages;

import com.enuygun.util.BasePage;
import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    private By signIn = By.id("ctx-LoginBtn");

    @Step("Login Sayfasını Getir")
    public void getLoginPage() {


        clickObject(signIn, "Giriş yapa tıkla.");

        Assert.assertEquals("Değerler Eşit Değil", "Şifremi Unuttum", getText(By.xpath("//*[@class='membership--dialog-navigation-forgot-password katalon__modal-navigation-forgot-password']")));
    }

    @Step("Kullanıcı Emaili ve Şifreyi Gir")
    public void setLoginData() {
        fillInputField(By.name("_email"), "cagataycagli34@yandex.com");
        fillInputField(By.xpath("//*[@class='MuiInputBase01198 MuiOutlinedInput01183 MuiInputBase01201 MuiInputBase01204 MuiOutlinedInput01187 katalon__modal-password']"), "Enuygun34");
        clickObject(By.xpath("//*[@class='MuiButtonBase01218 MuiButton01221 MuiButton01232 MuiButton01233 MuiButton01235 MuiButton01236 membership--login-button katalon__modal-login-button']"), "Üye girişine tıkla.");
    }

    @Step("Giriş Yapıldı mı?")
    public void isLogin() {
        Assert.assertTrue("Giriş Yapılamadı.", isElementDisplayed(By.xpath("//*[@class='align-middle NavbarUsername']")));
    }
}
