package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageLocators.OpenAccountLocators;

import java.util.List;

import static pageLocators.OpenAccountLocators.currenciesList;
import static pageLocators.OpenAccountLocators.processButton;

public class OpenAccountPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public OpenAccountPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
    }

    public void selectCustomerName(String fullNameValue){
        elementHelper.selectLocator(OpenAccountLocators.customerNameElement, fullNameValue);
    }
    public void selectCurrency(String currencyValue){
        elementHelper.selectLocator(OpenAccountLocators.currencyElement, currencyValue);
    }
    public void selectButton(){
        elementHelper.clickLocator(OpenAccountLocators.processButton);
        alertHelper.acceptAlert();
        LoggerUtility.infoTest("The user clicked on accept alert");
    }
    public void selectButton2(){
        elementHelper.clickLocator(OpenAccountLocators.processButton);
    }
    public boolean isOpenCustomerButtonDisplayed() {
        return elementHelper.isElementDisplayed(processButton);
    }
    public void selectCurrenciesList(){
        elementHelper.clickJSLocator(OpenAccountLocators.currenciesList);
    }
    public boolean isCurrencyDisplayed(String currency) {
        List<WebElement> options = driver.findElements(OpenAccountLocators.currenciesList);
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(currency)) {
                return true;
            }
        }
        return false;
    }
    private By currencyDropdown = By.cssSelector("#currency");
    public String getCurrencyFieldValidationMessage() {
        return elementHelper.getValidationMessage(currencyDropdown);
    }
}
