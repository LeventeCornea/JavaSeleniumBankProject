package tests.bankManagerTests.negativeCases.invalidAccountsCreation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BankManagerPage;
import pages.CustomersPage;
import pages.IndexPage;
import pages.OpenAccountPage;
import sharedData.SharedData;

import java.awt.*;

public class OpenAccountWithoutCurrencyTest extends SharedData {

    @Test
    public void testMethod() throws AWTException {

        String firstNameValue = "Harry";
        String lastNameValue = "Potter";
        String fullNameValue = firstNameValue + " " + lastNameValue;

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickOpenAccountElement();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectCustomerName(fullNameValue);
        openAccountPage.selectButton2();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String validationMessage = openAccountPage.getCurrencyFieldValidationMessage();
        System.out.println("Browser validation message: " + validationMessage);
        Assert.assertTrue(validationMessage.equals("Please select an item in the list."), "Account is not opened without selected currency!");
    }
}