package com.automation.context;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TextContext {

    public static final String CHROME = "chrome";
    public static final String GECKO = "gecko";
    public static WebDriver webDriver=null;

    public static WebDriver getWebDriver()
    {
        System.out.println("getWebDriver");
        try {

            if (GECKO.equals(System.getProperty("driver"))) {
                System.out.println("gecko");
                webDriver = createGeckoDriver();
            } else if(CHROME.equals(System.getProperty("driver"))) {
                System.out.println("chrome");
                webDriver = createChromeDriver();
            }

        } catch (Exception ex) {
            System.out.println("Exception in getWebDriver");
        }
        System.out.println("bitti");
        return webDriver;
    }


    public static WebDriver createGeckoDriver() {
        if ("Windows".equals(System.getProperty("os.name"))) {
            System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckoDriver/geckodriver.exe");
        } else if (System.getProperty("os.name").equals("Mac OS X")) {
            System.out.println("Mac için gecko");
            System.setProperty("webdriver.gecko.driver", "./src/main/resources/geckoDriverForMac/geckodriver");
        }
        return new FirefoxDriver();
    }

    public static WebDriver createChromeDriver() {

        if ("Windows".equals(System.getProperty("os.name"))) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromeDriverForWindows_98/chromedriver.exe");

        } else if (System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriverForMac_98/chromedriver");
        }
        ChromeOptions options = new ChromeOptions();
        return new ChromeDriver(options);
    }
}
