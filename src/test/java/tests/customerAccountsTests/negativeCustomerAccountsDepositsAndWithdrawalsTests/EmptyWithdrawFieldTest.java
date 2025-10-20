package tests.customerAccountsTests.negativeCustomerAccountsDepositsAndWithdrawalsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerAccountTransactionsPage;
import pages.CustomerLoginPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.awt.*;

public class EmptyWithdrawFieldTest extends SharedData {

    @Test
    public void testMethod() throws AWTException {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickCustomerLogin();

        String firstNameValue = "Harry";
        String lastNameValue = "Potter";
        String fullNameValue = firstNameValue + " " + lastNameValue;

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        customerLoginPage.selectCustomerName(fullNameValue);
        customerLoginPage.selectLoginButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CustomerAccountPage accountPage = new CustomerAccountPage(driver);

        accountPage.selectWithdrawButton();

        accountPage.selectConfirmWithdrawalButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        accountPage.selectTransactionsHistoryButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        CustomerAccountTransactionsPage customerAccountTransactionsPage = new CustomerAccountTransactionsPage(driver);

        Assert.assertFalse(customerAccountTransactionsPage.isCustomerRowDisplayed(), "Transactions table is empty");
    }
}