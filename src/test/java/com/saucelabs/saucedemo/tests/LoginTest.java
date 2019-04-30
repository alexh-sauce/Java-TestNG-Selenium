package com.saucelabs.saucedemo.tests;

import com.saucelabs.saucedemo.pages.InventoryPage;
import com.saucelabs.saucedemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseWebDriverTest {
    @Test
    public void loginTestValid() {
        InventoryPage inventoryPage = getNavigation().login("standard_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isOnPage());
    }

    @Test
    public void loginTestValidPerfGlitch() {
        InventoryPage inventoryPage = getNavigation().login("performance_glitch_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isOnPage());
    }

    @Test
    public void loginTestValidLockedOut() {
        LoginPage loginPage = getNavigation().getLoginPage();
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.epicSadFaceDisplayed());
    }

    @Test
    public void loginTestValidProblem() {
        InventoryPage inventoryPage = getNavigation().login("problem_user", "secret_sauce");
        Assert.assertTrue(inventoryPage.isOnPage());
    }

    @Test
    public void loginTestInvalidUsername() {
        LoginPage loginPage = getNavigation().getLoginPage();
        loginPage.login("invalid_user", "secret_sauce");
        Assert.assertTrue(loginPage.isOnPage());
    }

    @Test
    public void loginTestInvalidPassword() {
        LoginPage loginPage = getNavigation().getLoginPage();
        getNavigation().login("standard_user", "invalid_password");
        Assert.assertTrue(loginPage.isOnPage());
    }
}