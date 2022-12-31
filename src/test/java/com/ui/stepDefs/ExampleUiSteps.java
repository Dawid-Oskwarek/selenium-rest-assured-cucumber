package com.ui.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ui.support.pages.HtmlElementsPage;
import com.ui.support.pages.SuccessPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ExampleUiSteps {
    public static WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/ui/drivers/chromedriverwindows.exe");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
        options.addArguments("--disable-web-security");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
    }

    @After
    public void cleanup() {
        driver.quit();
    }

    HtmlElementsPage elementsPage = new HtmlElementsPage(driver);
    SuccessPage successPage = new SuccessPage(driver);

    @Given("I access the website")
    public void accessWebsite() {
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
    }

    @When("I click on class button")
    public void clickOnClassButton()  {
        elementsPage.clickButton();
    }

    @Then("I receive a success message")
    public void validateSuccessMessage() {
    successPage.assertSuccessMessageIsVisible();
    }
}
