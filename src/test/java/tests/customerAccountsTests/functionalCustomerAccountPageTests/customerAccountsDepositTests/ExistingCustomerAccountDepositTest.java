package tests.customerAccountsTests.functionalCustomerAccountPageTests.customerAccountsDepositTests;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;

public class
ExistingCustomerAccountDepositTest extends SharedData {
    @Test
    public void testMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickCustomerLogin();

        String firstNameValue = "Harry";
        String lastNameValue = "Potter";
        String fullNameValue = firstNameValue+" "+lastNameValue;
        String depositSum = "50";
        String transactionType = "Credit";

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        customerLoginPage.selectCustomerName(fullNameValue);
        customerLoginPage.selectLoginButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CustomerAccountPage accountPage = new CustomerAccountPage(driver);
        accountPage.selectDepositButton();
        accountPage.fillDepositAmount(depositSum);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountPage.selectConfirmDepositButton();
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
        CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);
        String transactionDate = customerAccountTransactionsPage.getCurrentTransactionDate();
        customerAccountTransactionsPage.validateCustomerData(transactionDate, depositSum, transactionType);
        customerAccountTransactionsPage.selectResetButton();

        customerAccountTransactionsPage.selectBackButton();
        customerAccountPage.selectLogoutButton();
    }
}
