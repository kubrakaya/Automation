package com.automation.test;

import com.automation.context.TextContext;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected static WebDriver driver = null;

    public static void initalizeTests() {
        System.out.println(" START : initalizeTests");
        //todo: getWebDriver satırı açılırsa, config ayarlarından -Ddriver=chrome girilmeli
        //driver = TextContext.getWebDriver();
        driver = TextContext.createChromeDriver();

    }

    public static void finishTests() {
        System.out.println("START : finishTests");
        driver.close();
        driver.quit();

    }
}
