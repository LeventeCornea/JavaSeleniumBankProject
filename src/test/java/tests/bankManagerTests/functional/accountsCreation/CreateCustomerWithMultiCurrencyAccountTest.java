package tests.bankManagerTests.functional.accountsCreation;

import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;

public class CreateCustomerWithMultiCurrencyAccountTest extends SharedData {

    @Test
    public void testMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerElement();

        String firstNameValue = "Levente";
        String lastNameValue = "Cornea";
        String postCodeValue = "251569";
        String fullNameValue = firstNameValue+" "+lastNameValue;
        String[] currencies = {"Dollar", "Pound", "Rupee"};

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

        for (int i = 0; i < currencies.length; i++) {
            OpenAccountPage openAccountPage = new OpenAccountPage(driver);
            openAccountPage.selectCustomerName(fullNameValue);
            openAccountPage.selectCurrency(currencies[i]);
            openAccountPage.selectButton();
        }
    }
}
