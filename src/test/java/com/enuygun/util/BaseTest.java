package com.enuygun.util;

import com.enuygun.Helper.Configuration;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static Configuration configurationGet = Configuration.getInstance();
	protected static WebDriver driver;

    @BeforeScenario
	public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();


            driver = new ChromeDriver(capabilities);
            ChromeOptions options = new ChromeOptions();

            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            options.setExperimentalOption("useAutomationExtension", false);
            options.addArguments("--disable-blink-features");
            options.addArguments("--disable-blink-features=AutomationControlled");

            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");
            driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
            driver.manage().window().maximize();


            driver.navigate().to(configurationGet.getWebURL());
	}



	@AfterScenario
	public void tearDown() {
		driver.quit();
	}
}