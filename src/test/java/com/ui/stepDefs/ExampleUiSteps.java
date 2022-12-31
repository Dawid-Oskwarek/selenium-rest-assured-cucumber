package com.ui.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.ui.support.pages.HtmlElementsPage;
import com.ui.support.pages.SuccessPage;
import org.openqa.selenium.WebDriver;
import com.ui.runner.UiRunner;


public class ExampleUiSteps {
    private WebDriver driver;
    private HtmlElementsPage elementsPage;
    private SuccessPage successPage;

    public ExampleUiSteps() {
        this.driver = UiRunner.driver;
    }

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
