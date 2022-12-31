package com.ui.support.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HtmlElementsPage {
    private WebDriver driver;

    @FindBy(className="buttonClass")
    private WebElement button;

    public HtmlElementsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButton() {
        button.click();
    }
}
