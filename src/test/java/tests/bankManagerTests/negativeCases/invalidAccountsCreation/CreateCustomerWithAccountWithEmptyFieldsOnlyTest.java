package tests.bankManagerTests.negativeCases.invalidAccountsCreation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

public class CreateCustomerWithAccountWithEmptyFieldsOnlyTest extends SharedData {

    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerElement();

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.clickAddCustomerButtonWithEmptyField();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String firstNameFieldValidationMessage = addCustomerPage.getFirstNameFieldValidationMessage();
        System.out.println("Validation message shown: " + firstNameFieldValidationMessage);
        Assert.assertTrue(firstNameFieldValidationMessage.equals("Please fill out this field."), "Expected browser validation message was displayed!");
    }
}