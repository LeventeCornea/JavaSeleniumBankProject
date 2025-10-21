package tests.bankManagerTests.negativeCases.unavailableCurrencyAccountsCreation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BankManagerPage;
import pages.IndexPage;
import pages.OpenAccountPage;
import sharedData.SharedData;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CreateCustomerWithUnavailableCurrencyTest extends SharedData {

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
        String currencyValue = "Yen";

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
        openAccountPage.selectCurrenciesList();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertFalse(openAccountPage.isCurrencyDisplayed(currencyValue), "Account is opened with unavailable currency!");
    }
}
