package tests.customerAccountsTests.functionalCustomerAccountPageTests.customerAccountsDepositTests;

import sharedData.SharedData;
import org.testng.annotations.Test;
import pages.*;

import java.awt.*;
import java.awt.event.KeyEvent;

public class NewlyCreatedCustomersAccountsWithMultipleDepositsTest extends SharedData {
    @Test
    public void testMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerElement();

        String[] firstNameValue = {"Levente", "Alice", "Bob", "Jason"};
        String[] lastNameValue = {"Cornea", "Johnson", "Smith", "Angelo"};
        String[] postCodeValue = {"251569", "123456", "654321", "556678"};
        String[] fullNameValue = new String[firstNameValue.length];
        for (int i = 0; i < firstNameValue.length; i++) {
            fullNameValue[i] = firstNameValue[i] + " " + lastNameValue[i];
        }
        String currencyValue = "Dollar";
        String[] depositSum = {"50", "25", "125", "1000"};
        String transactionType = "Credit";

        for (int i = 0; i < firstNameValue.length; i++) {
            AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
            addCustomerPage.fillFirstName(firstNameValue[i]);
            addCustomerPage.fillLastName(lastNameValue[i]);
            addCustomerPage.fillPostCode(postCodeValue[i]);
            addCustomerPage.clickAddCustomerButton();
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        bankManagerPage.clickOpenAccountElement();
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);


        for (int i = 0; i < fullNameValue.length; i++) {
            openAccountPage.selectCustomerName(fullNameValue[i]);
            openAccountPage.selectCurrency(currencyValue);
            openAccountPage.selectButton();
        }


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        indexPage.clickHomePageButton();

        indexPage.clickCustomerLogin();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        for (int i = 0; i < fullNameValue.length; i++) {
            customerLoginPage.selectCustomerName(fullNameValue[i]);
            customerLoginPage.selectLoginButton();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            CustomerAccountPage accountPage = new CustomerAccountPage(driver);
            accountPage.selectDepositButton();
            accountPage.fillDepositAmount(depositSum[i]);
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
            customerAccountTransactionsPage.validateTransactionRow(transactionDate, depositSum[i], transactionType);
            customerAccountTransactionsPage.selectResetButton();
            customerAccountTransactionsPage.selectBackButton();
            customerAccountPage.selectLogoutButton();
            indexPage.clickHomePageButton();
            indexPage.clickCustomerLogin();
        }
    }
}
