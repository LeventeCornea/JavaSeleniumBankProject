package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.BankManagerLocators;

public class BankManagerPage {
    private WebDriver driver;
    private ElementHelper elementHelper;

    public BankManagerPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }
    public void clickAddCustomerElement(){
        elementHelper.clickLocator(BankManagerLocators.addCustomerElement);
    }
    public void clickOpenAccountElement(){
        elementHelper.clickJSLocator(BankManagerLocators.openAccountElement);
    }
    public void clickCustomersElement(){
        elementHelper.clickJSLocator(BankManagerLocators.customersElement);
    }
}
