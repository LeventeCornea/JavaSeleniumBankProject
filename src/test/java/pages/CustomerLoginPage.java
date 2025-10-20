package pages;

import helpMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageLocators.CustomerLoginLocators;

import java.util.List;

public class CustomerLoginPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    public CustomerLoginPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }
    public void selectCustomerName(String fullNameValue){
        elementHelper.selectLocator(CustomerLoginLocators.customersList, fullNameValue);
    }
    public void selectLoginButton(){
        elementHelper.clickJSLocator(CustomerLoginLocators.loginButton);
    }
    public void selectCustomerNameList(){
        elementHelper.clickLocator(CustomerLoginLocators.customersList);
    }
    public boolean isCustomerPresent(String fullName) {
        List<WebElement> options = driver.findElements(CustomerLoginLocators.customerOptions);
        for (WebElement option : options) {
            if (option.getText().trim().equalsIgnoreCase(fullName)) {
                return true;
            }
        }
        return false;
    }
}
