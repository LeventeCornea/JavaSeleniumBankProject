package pages;

import helpMethods.ElementHelper;
import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageLocators.AddCustomersLocators;
import pageLocators.CustomerAccountLocators;
import pageLocators.CustomerLoginLocators;
import pageLocators.IndexLocators;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static pageLocators.AddCustomersLocators.firstNameElement;

public class CustomerAccountPage {
    private WebDriver driver;
    private ElementHelper elementHelper;
    private IndexLocators indexLocators;


    public CustomerAccountPage(WebDriver driver) {
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }

    public List<String> getAllAccountNumbers() {
        WebElement dropdown = driver.findElement(CustomerAccountLocators.customerAccountNumber);
        Select select = new Select(dropdown);
        return select.getOptions()
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public void selectAccountNumber(String accountNumber) {
        WebElement dropdown = driver.findElement(CustomerAccountLocators.customerAccountNumber);
        Select select = new Select(dropdown);
        select.selectByVisibleText(accountNumber);
    }

    public String getSelectedAccountNumber() {
        Select select = new Select(driver.findElement(CustomerAccountLocators.customerAccountNumber));
        return select.getFirstSelectedOption().getText().trim();
    }

    public boolean isAccountPageDisplayed() {
        return elementHelper.isElementDisplayed(CustomerAccountLocators.customerAccountNumber);
    }

    public void selectTransactionsHistoryButton() {
        elementHelper.clickLocator(CustomerAccountLocators.transactionsHistoryButton);
    }

    public void selectDepositButton() {
        elementHelper.clickJSLocator(CustomerAccountLocators.depositButton);
    }
    public void fillDepositAmount(String depositSum) {
        elementHelper.fillLocator(CustomerAccountLocators.depositAndWithdrawAmountField, depositSum);
    }

    public void selectConfirmDepositButton() {
        elementHelper.clickJSLocator(CustomerAccountLocators.confirmDepositAndWithdrawalButton);
    }
    public void selectWithdrawButton() {
        elementHelper.clickJSLocator(CustomerAccountLocators.withdrawButton);
    }
    public void fillWithdrawAmount(String withdrawSum){
        elementHelper.fillLocator(CustomerAccountLocators.depositAndWithdrawAmountField, withdrawSum);
    }
    public void selectConfirmWithdrawalButton(){
        elementHelper.clickJSLocator(CustomerAccountLocators.confirmDepositAndWithdrawalButton);
    }
    public void selectLogoutButton(){
        elementHelper.clickLocator(CustomerAccountLocators.logoutButton);
    }
}
