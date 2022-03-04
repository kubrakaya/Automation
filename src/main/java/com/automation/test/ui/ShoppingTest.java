package com.automation.test.ui;

import com.automation.common.UiLabel;
import com.automation.config.RunConfig;
import com.automation.page.AddToChartPage;
import com.automation.page.LoginPage;
import com.automation.test.BaseTest;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ShoppingTest extends BaseTest {


    public static LoginPage loginPage;
    public static AddToChartPage addToChartPage;
    //automationmail@yopmail.com
    //password: Hk9.1111

    @BeforeAll
    public static void setup()
    {
        System.out.println("setup");
        initalizeTests();
        loginPage = new LoginPage(driver);
        addToChartPage = new AddToChartPage(driver);
    }

    @Test
    @Order(1)
    public void isLoggedIn() throws InterruptedException {

        loginPage.getDashboardPage();
        loginPage.clickMasterSignInButton();
        loginPage.isLoginPageOpened();
        Assertions.assertTrue(loginPage.isLoginPageOpened());
        loginPage.login(RunConfig.getInstance().getUsername(),RunConfig.getInstance().getPassword());
        Assertions.assertTrue(loginPage.isLoggedIn());
    }

    @Test
    @Order(2)
    public void addProductToChart() throws InterruptedException {

        addToChartPage.enterProductNameToSearchTextArea(UiLabel.ProductName.getDefinition());
        addToChartPage.addToChart();
        addToChartPage.isAddedToChart();

    }


    @AfterAll
    public static void finish() {
        System.out.println("Called finish() in LoginTest.java");
        finishTests();
    }
}
