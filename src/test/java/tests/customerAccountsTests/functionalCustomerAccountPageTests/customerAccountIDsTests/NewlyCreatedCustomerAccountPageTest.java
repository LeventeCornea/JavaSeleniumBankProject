package tests.customerAccountsTests.functionalCustomerAccountPageTests.customerAccountIDsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class NewlyCreatedCustomerAccountPageTest extends SharedData {
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

            List<String> allAccounts = accountPage.getAllAccountNumbers();

            System.out.println("All accounts for " + fullNameValue + ": " + allAccounts);

            for (String accountNumber : allAccounts) {
                accountPage.selectAccountNumber(accountNumber);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                String selected = accountPage.getSelectedAccountNumber();
                System.out.println("Selected account: " + selected);

                Assert.assertEquals(selected, accountNumber, "Account number does not match!");
            }
            CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);
            customerAccountPage.selectLogoutButton();
        }
    }
