package com.saucelabs.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoNavigation {
    private WebDriver driver;
    public SauceDemoNavigation(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(driver, loginPage);
        return loginPage;
    }

    public InventoryPage login(String username, String password) {
        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(driver, loginPage);
        driver.get(loginPage.getUrl());
        return loginPage.login(username, password);
    }

    public InventoryPage getInventoryPage() {
        InventoryPage inventoryPage = new InventoryPage();
        PageFactory.initElements(driver, inventoryPage);
        return inventoryPage;
    }
}
