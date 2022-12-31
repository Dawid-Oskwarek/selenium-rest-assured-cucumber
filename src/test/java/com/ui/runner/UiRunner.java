package com.ui.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(tags = "@ui", features = "src/test/resources/ui/features", glue = { "com.ui.stepDefs" })


public class UiRunner extends AbstractTestNGCucumberTests {
    public static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/ui/drivers/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-gpu"); // applicable to windows os only
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() {
        driver.quit();
    }
    
}
