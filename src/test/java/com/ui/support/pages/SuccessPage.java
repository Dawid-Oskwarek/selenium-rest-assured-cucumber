package com.ui.support.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class SuccessPage {
    private WebDriver driver;

    @FindBy(css = "text=Button success")
    private WebElement message;

    public SuccessPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void assertSuccessMessageIsVisible() {
        assertTrue(message.isDisplayed());
    }
}
