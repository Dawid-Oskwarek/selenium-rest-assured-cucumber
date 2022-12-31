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
        options.addArguments("--headless"); // open Browser in maximized mode
        driver = new ChromeDriver(options);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDownClass() {
        driver.quit();
    }
    
}
