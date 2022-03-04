package com.automation.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.automation.common.UiLabel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AddToChartPage extends BasePage{

    @FindBy(css="input[id='search_query_top']")
    private WebElement searchInput;

    @FindBy(css="button[name='submit_search']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]")
    private WebElement selectedProductAddToChartButton;

    @FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
    private WebElement selectedProductImage;

    @FindBy(css="a[id='color_1']")
    private WebElement selectedProductColorIconButton;

    @FindBy(css="div.product-container[itemtype='http://schema.org/Product']")
    private WebElement selectedProductBox;

    @FindBy(css="div.clearfix")
    private WebElement addToChartPopUp;

    @FindBy(css="a[title='Proceed to checkout']")
    private WebElement proceedToCheckout;

    public AddToChartPage(WebDriver driver) {
        super(driver);
    }

    public void enterProductNameToSearchTextArea(String productName) {

        if (productName == null) {
            throw new IllegalArgumentException("Passed parameter `productName` can not be null!");
        }
        CustomWait.waitForElementToBeVisible(searchInput,driver);
        CustomWait.waitForElementToBeClickable(searchInput,driver);
        searchInput.sendKeys(productName);
        searchInput.click();
        searchButton.click();
    }

    public void hover(WebElement webElement)
    {
        Actions action = new Actions(driver);
        action.moveToElement(webElement).perform();
    }



    public void addToChart(){

        CustomWait.waitForElementToBeVisible(selectedProductImage,driver);
        CustomWait.waitForElementToBeVisible(selectedProductColorIconButton,driver);
        driver.manage().window().fullscreen();
        hover(selectedProductBox);
        hover(selectedProductColorIconButton);
        CustomWait.waitForElementToBeClickable(selectedProductColorIconButton,driver);
        selectedProductColorIconButton.click();
        System.out.println("buton tıklanabilir mi");
        CustomWait.waitForElementToBeClickable(selectedProductAddToChartButton,driver);
        selectedProductAddToChartButton.click();
    }

    public boolean isAddedToChart() {
        CustomWait.waitForElementToBeVisible(addToChartPopUp,driver);
        hover(addToChartPopUp);
        CustomWait.waitForElementToBeVisible(proceedToCheckout,driver);
        return (proceedToCheckout.findElement(By.cssSelector("span")).getText().equalsIgnoreCase(UiLabel.ProceedToCheckoutButtonName.getDefinition()) ? true : false);
    }


}
