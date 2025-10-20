package tests.bankManagerTests.functional.accountsCreation;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CreateCustomerWithAccountTest extends SharedData {

    @Test
    public void testMethod() throws AWTException{

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerElement();

        String firstNameValue = "Levente";
        String lastNameValue = "Cornea ";
        String postCodeValue = "251569";
        String fullNameValue = firstNameValue+" "+lastNameValue;
        String currencyValue = "Dollar";

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.fillFirstName(firstNameValue);
        addCustomerPage.fillLastName(lastNameValue);
        addCustomerPage.fillPostCode(postCodeValue);
        addCustomerPage.clickAddCustomerButton();

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
        openAccountPage.selectCustomerName(fullNameValue);
        openAccountPage.selectCurrency(currencyValue);
        openAccountPage.selectButton();

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bankManagerPage.clickCustomersElement();
        CustomersPage customersPage = new CustomersPage(driver);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        customersPage.searchCustomers(lastNameValue);
        customersPage.validateCustomer(firstNameValue, lastNameValue, postCodeValue);
        customersPage.deleteCustomer();
    }
}
