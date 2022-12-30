package com.ui.support.pages;

import com.ui.runner.UiRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HtmlElementsPage {
    private WebDriver driver;

    @FindBy(className = "buttonClass")
    private WebElement button;

    public HtmlElementsPage(WebDriver driver) {
        this.driver = UiRunner.driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButton() {
        button.click();
    }
}
