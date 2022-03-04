package com.automation.page;

import com.automation.common.UiLabel;
import com.automation.config.RunConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    @FindBy(css = "a[title='Log in to your customer account']")
    private WebElement masterSignInButton;

    @FindBy(css = "button[id='SubmitLogin']")
    private WebElement signInButton;

    @FindBy(css = "input[id='email']")
    private WebElement usernameInput;

    @FindBy(css = "input[id='passwd']")
    private WebElement passwordInput;

    @FindBy(css = "div[class='col-xs-12 col-sm-6']>form[id='login_form']>h3.page-subheading")
    private WebElement loginPage;

    @FindBy(css="div[id='center_column']>p.info-account")
    private WebElement myAccountPage;


    @FindBy(css="span[id='view_full_size']>img[id='bigpic']")
    private WebElement selectedProductBigImage;


   @FindBy(css="div#layer_cart>div.clearfix>div.layer_cart_product col-xs-12 col-md-6>h2")
   private WebElement addToChartPopUpLabel;



   @FindBy(css="div#center_column>h1#cart_title")
   private WebElement cartSummaryLabel;

    public LoginPage(WebDriver driver) {
        super(driver);
        System.out.println("Constructor LoginPage");
    }

    public void getDashboardPage() {

        driver.get(RunConfig.getInstance().getUiHost());
        CurtainPage.waitUntilCurtainGoOn(driver);
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
    }

    public void clickMasterSignInButton() throws InterruptedException {

        CustomWait.waitForElementToBeClickable(masterSignInButton, driver);
        masterSignInButton.click();
    }

    public boolean isLoginPageOpened() {

        CustomWait.waitForElementToBeVisible(loginPage,driver);
        return (loginPage.getText().equalsIgnoreCase(UiLabel.ALREADYREGISTERED.getDefinition()) ? true : false);
    }

    public void enterLoginCredentials(String username, String password) {

        enterUsername(username);

        enterPassword(password);
    }

    public void enterUsername(String username) {

        if (username == null) {
            throw new IllegalArgumentException("Passed parameter `username` can not be null!");
        }
        CustomWait.waitForElementToBeVisible(usernameInput,driver);
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {

        if (password == null) {
            throw new IllegalArgumentException("Passed parameter `password` can not be null!");
        }
        CustomWait.waitForElementToBeVisible(passwordInput,driver);
        passwordInput.sendKeys(password);
    }


    public void login(String username, String password) {

        try {
            enterLoginCredentials(username, password);
            clickSignInButton();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean isLoggedIn() throws InterruptedException {

        CustomWait.waitForElementToBeVisible(myAccountPage,driver);
        return (myAccountPage.getText().equalsIgnoreCase(UiLabel.WelcomeToYourAccount.getDefinition()) ? true : false);
    }


    public void clickSignInButton() throws InterruptedException {

        Thread.sleep(1000);
        new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
    }




}
