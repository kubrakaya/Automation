package com.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

    public class CurtainPage extends BasePage {

        @FindBy(css = "div[id='page']")
        private static WebElement mainDashboard;
        private static By mainDashboardLocator = By.cssSelector("div[id='page']");

        public CurtainPage(WebDriver driver) {
            super(driver);
        }
        public static void waitUntilCurtainGoOn(WebDriver driver) {
            CustomWait.waitForElementToBePresence(mainDashboardLocator, driver);
        }
    }

