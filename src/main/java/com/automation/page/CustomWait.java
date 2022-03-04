package com.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {

    private static final int TIMEOUT_IN_SECONDS_S = 5;
    private static final int TIMEOUT_IN_SECONDS_M = 10;
    public static final int TIMEOUT_IN_SECONDS_15 = 15;
    public static final int TIMEOUT_IN_SECONDS_20 = 20;


    public static void waitForElementToBeVisible(WebElement element, WebDriver driver) {

        try {
            new WebDriverWait(driver, TIMEOUT_IN_SECONDS_15).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            //TODO: Wait'ten dönebilecek hata türlerinin herbirini handle et
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeVisible(WebElement element, WebDriver driver,int time) {

        try {
            new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            //TODO: Wait'ten dönebilecek hata türlerinin herbirini handle et
            e.printStackTrace();
        }
    }

    public static void waitForElementToBePresence(By locator, WebDriver driver) {

        try {
            System.out.println("waitForElementToBePresence");
            new WebDriverWait(driver, TIMEOUT_IN_SECONDS_M).until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void waitForElementToBeClickable(WebElement element, WebDriver driver) {

        try {
            System.out.println("waitForElementToBeClickable");
            new WebDriverWait(driver, TIMEOUT_IN_SECONDS_15).until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void waitForElementToBeInvisible(WebElement element, WebDriver driver) {
        try {
            System.out.println("waitForElementToBeInvisible");
            new WebDriverWait(driver, TIMEOUT_IN_SECONDS_M).until(ExpectedConditions.invisibilityOf(element));
        } catch (Exception ex) {
        ex.printStackTrace();
        }

    }
}
