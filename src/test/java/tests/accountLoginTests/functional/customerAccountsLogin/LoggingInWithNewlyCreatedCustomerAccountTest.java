package tests.accountLoginTests.functional.customerAccountsLogin;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;
import java.awt.event.KeyEvent;

public class LoggingInWithNewlyCreatedCustomerAccountTest extends SharedData {

    @Test
    public void testMethod() throws AWTException {

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

        indexPage.clickHomePageButton();
        indexPage.clickCustomerLogin();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);
        customerLoginPage.selectCustomerName(fullNameValue);
        customerLoginPage.selectLoginButton();
        customerAccountPage.selectLogoutButton();
    }
}
