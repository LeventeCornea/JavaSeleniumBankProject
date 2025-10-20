package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import pageLocators.CustomersLocators;


import java.time.Duration;
import java.util.List;

import static pageLocators.OpenAccountLocators.processButton;

public class CustomersPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public CustomersPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }
    public void searchCustomers(String fullNameValue){
        elementHelper.fillLocator(CustomersLocators.customerName, fullNameValue);
    }

    public void validateCustomer(String firstNameValue, String lastNameValue, String postCodeValue){
        elementHelper.validateContainTextLocator(CustomersLocators.customerRow, firstNameValue);
        elementHelper.validateContainTextLocator(CustomersLocators.customerRow, lastNameValue);
        elementHelper.validateContainTextLocator(CustomersLocators.customerRow, postCodeValue);
    }
    public void deleteCustomer(){
        elementHelper.clickJSLocator(CustomersLocators.deleteButton);
    }
    public void deleteCustomerNameCP() {
        elementHelper.clearField(CustomersLocators.customerName);
    }
}