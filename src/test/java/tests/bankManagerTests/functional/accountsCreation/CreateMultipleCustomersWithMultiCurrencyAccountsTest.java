package tests.bankManagerTests.functional.accountsCreation;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CreateMultipleCustomersWithMultiCurrencyAccountsTest extends SharedData{
    @Test
    public void testMethod() throws AWTException{

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
        String[] currencyValue = {"Dollar", "Rupee", "Pound", "Dollar"};

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
            openAccountPage.selectCurrency(currencyValue[i]);
            openAccountPage.selectButton();
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bankManagerPage.clickCustomersElement();
        CustomersPage customersPage = new CustomersPage(driver);

        for (int i = 0; i < lastNameValue.length; i++) {
            customersPage.searchCustomers(lastNameValue[i]);
            customersPage.validateCustomer(firstNameValue[i], lastNameValue[i], postCodeValue[i]);
            customersPage.deleteCustomer();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            customersPage.deleteCustomerNameCP();
        }
        indexPage.clickHomePageButton();
    }
}
