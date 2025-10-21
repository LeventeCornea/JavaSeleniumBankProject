package tests.customerAccountsTests.functionalCustomerAccountPageTests.customerAccountsDepositTests;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;
import java.awt.event.KeyEvent;

public class NewlyCreatedCustomerAccountDepositTest extends SharedData {

    @Test
    public void testMethod(){
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerElement();

        String firstNameValue = "Levente";
        String lastNameValue = "Cornea";
        String postCodeValue = "251569";
        String fullNameValue = firstNameValue + " " + lastNameValue;
        String currencyValue = "Dollar";
        String depositSum = "50";
        String transactionType = "Credit";

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.fillFirstName(firstNameValue);
        addCustomerPage.fillLastName(lastNameValue);
        addCustomerPage.fillPostCode(postCodeValue);
        addCustomerPage.clickAddCustomerButton();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bankManagerPage.clickOpenAccountElement();
        OpenAccountPage openAccountPage = new OpenAccountPage(driver);

        openAccountPage.selectCustomerName(fullNameValue);
        openAccountPage.selectCurrency(currencyValue);
        openAccountPage.selectButton();


        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        indexPage.clickHomePageButton();

        indexPage.clickCustomerLogin();

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
