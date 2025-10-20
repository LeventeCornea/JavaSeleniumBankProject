package tests.customerAccountsTests.functionalCustomerAccountPageTests.customerAccountIDsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class NewlyCreatedCustomersAccountsPagesTest extends SharedData {
    @Test
    public void testMethod() throws AWTException {

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

        for (int i = 0; i < firstNameValue.length; i++) {
            AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
            addCustomerPage.fillFirstName(firstNameValue[i]);
            addCustomerPage.fillLastName(lastNameValue[i]);
            addCustomerPage.fillPostCode(postCodeValue[i]);
            addCustomerPage.clickAddCustomerButton();
        }

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

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

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

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
}
