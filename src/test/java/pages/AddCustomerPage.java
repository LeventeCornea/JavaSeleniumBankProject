package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pageLocators.AddCustomersLocators.*;

public class AddCustomerPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;

    public AddCustomerPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
        alertHelper = new AlertHelper(driver);
    }
    public void fillFirstName(String firstNameValue){
        elementHelper.fillLocator(firstNameElement, firstNameValue);
    }
    public void fillLastName(String lastNameValue){
        elementHelper.fillLocator(lastNameElement, lastNameValue);
    }
    public void fillPostCode(String postCodeValue){
        elementHelper.fillLocator(postCodeElement, postCodeValue);
    }
    public void clickAddCustomerButton(){
        elementHelper.clickLocator(addCustomerButton);
        alertHelper.acceptAlert();
    }
    public void clickAddCustomerButtonWithEmptyField(){
        elementHelper.clickLocator(addCustomerButton);
    }
    public void clickAddCustomerButton2(){
        elementHelper.clickLocator(addCustomerButton);
    }
    public boolean isAddCustomerButtonDisplayed() {
        return elementHelper.isElementDisplayed(addCustomerButton);
    }
    public void clearFirstNameACP() {
        elementHelper.clearLocator(firstNameElement);
    }
    public void clearLastNameACP() {
        elementHelper.clearLocator(lastNameElement);
    }
    public void clearPostCodeACP() {
        elementHelper.clearLocator(postCodeElement);
    }
    public String getAlertTextAndAccept() {
        alertHelper.waitForAlertVisible();
        String text = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return text;
    }
    public String getFirstNameFieldValidationMessage() {
        return elementHelper.getAttribute(firstNameElement, "validationMessage");
    }
    public String getLastNameFieldValidationMessage() {
        return elementHelper.getAttribute(lastNameElement, "validationMessage");
    }
    public String getPostCodeFieldValidationMessage() {
        return elementHelper.getAttribute(postCodeElement, "validationMessage");
    }
}
