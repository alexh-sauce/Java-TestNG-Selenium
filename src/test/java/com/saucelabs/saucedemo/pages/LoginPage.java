package com.saucelabs.saucedemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private String url = "https://www.saucedemo.com/";

    String getUrl() {
        return url;
    }

    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(className = "btn_action")
    private WebElement submitButton;

    @FindBy(id = "login_credentials")
    private WebElement credentialsInfo;

    @FindBy(className = "svg-inline--fa")
    private WebElement epicSadFace;

    LoginPage() {}

    public boolean isOnPage() {
        return credentialsInfo.isDisplayed();
    }

    public InventoryPage login(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new InventoryPage();
    }

    public boolean epicSadFaceDisplayed() {
        return epicSadFace.isDisplayed();
    }
}
