package tests.bankManagerTests.negativeCases.invalidAccountsCreation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BankManagerPage;
import pages.IndexPage;
import sharedData.SharedData;

public class CreateCustomerWithAccountWithPartialEmptyFieldTest extends SharedData {
    @Test
    public void testMethod() {
        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerElement();

        String firstNameValue = "Levente";
        String lastNameValue = "Cornea";
        String postCodeValue = "251569";

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.fillFirstName(firstNameValue);
        addCustomerPage.fillLastName(lastNameValue);
        addCustomerPage.clickAddCustomerButtonWithEmptyField();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String postCodeFieldValidationMessage1 = addCustomerPage.getPostCodeFieldValidationMessage();
        System.out.println("Validation message shown: " + postCodeFieldValidationMessage1);
        Assert.assertTrue(postCodeFieldValidationMessage1.equals("Please fill out this field."), "Expected browser validation message was displayed!");

        addCustomerPage.clearFirstNameACP();
        addCustomerPage.clearLastNameACP();

        addCustomerPage.fillLastName(lastNameValue);
        addCustomerPage.fillPostCode(postCodeValue);
        addCustomerPage.clickAddCustomerButtonWithEmptyField();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String firstNameFieldValidationMessage1 = addCustomerPage.getFirstNameFieldValidationMessage();
        System.out.println("Validation message shown: " + firstNameFieldValidationMessage1);
        Assert.assertTrue(firstNameFieldValidationMessage1.equals("Please fill out this field."), "Expected browser validation message was displayed!");

        addCustomerPage.clearLastNameACP();
        addCustomerPage.clearPostCodeACP();

        addCustomerPage.fillFirstName(firstNameValue);
        addCustomerPage.fillPostCode(postCodeValue);
        addCustomerPage.clickAddCustomerButtonWithEmptyField();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String lastNameFieldValidationMessage1 = addCustomerPage.getLastNameFieldValidationMessage();
        System.out.println("Validation message shown: " + lastNameFieldValidationMessage1);
        Assert.assertTrue(lastNameFieldValidationMessage1.equals("Please fill out this field."), "Expected browser validation message was displayed!");

        addCustomerPage.clearFirstNameACP();
        addCustomerPage.clearPostCodeACP();

        addCustomerPage.fillFirstName(firstNameValue);
        addCustomerPage.clickAddCustomerButtonWithEmptyField();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String lastNameFieldValidationMessage2 = addCustomerPage.getLastNameFieldValidationMessage();
        String postCodeFieldValidationMessage2 = addCustomerPage.getPostCodeFieldValidationMessage();
        System.out.println("Validation message shown: " + lastNameFieldValidationMessage2);
        System.out.println("Validation message shown: " + postCodeFieldValidationMessage2);
        Assert.assertTrue(lastNameFieldValidationMessage2.equals("Please fill out this field."), "Expected browser validation message was displayed!");
        Assert.assertTrue(postCodeFieldValidationMessage2.equals("Please fill out this field."), "Expected browser validation message was displayed!");


        addCustomerPage.clearFirstNameACP();

        addCustomerPage.fillLastName(lastNameValue);
        addCustomerPage.clickAddCustomerButtonWithEmptyField();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String firstNameFieldValidationMessage2 = addCustomerPage.getFirstNameFieldValidationMessage();
        String postCodeFieldValidationMessage3 = addCustomerPage.getPostCodeFieldValidationMessage();
        System.out.println("Validation message shown: " + firstNameFieldValidationMessage2);
        System.out.println("Validation message shown: " + postCodeFieldValidationMessage3);
        Assert.assertTrue(firstNameFieldValidationMessage2.equals("Please fill out this field."), "Expected browser validation message was displayed!");
        Assert.assertTrue(postCodeFieldValidationMessage3.equals("Please fill out this field."), "Expected browser validation message was displayed!");

        addCustomerPage.clearLastNameACP();

        addCustomerPage.fillPostCode(postCodeValue);
        addCustomerPage.clickAddCustomerButtonWithEmptyField();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String firstNameFieldValidationMessage3 = addCustomerPage.getFirstNameFieldValidationMessage();
        String lastNameFieldValidationMessage3 = addCustomerPage.getLastNameFieldValidationMessage();
        System.out.println("Validation message shown: " + firstNameFieldValidationMessage3);
        System.out.println("Validation message shown: " + lastNameFieldValidationMessage3);
        Assert.assertTrue(firstNameFieldValidationMessage3.equals("Please fill out this field."), "Expected browser validation message was displayed!");
        Assert.assertTrue(lastNameFieldValidationMessage3.equals("Please fill out this field."), "Expected browser validation message was displayed!");
    }
}
