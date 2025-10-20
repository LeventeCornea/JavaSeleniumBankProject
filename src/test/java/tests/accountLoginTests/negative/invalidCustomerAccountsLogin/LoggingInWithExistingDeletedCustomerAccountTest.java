package tests.accountLoginTests.negative.invalidCustomerAccountsLogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;

public class LoggingInWithExistingDeletedCustomerAccountTest extends SharedData{

    @Test
    public void testMethod() throws AWTException{

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);

        String firstNameValue = "Harry";
        String lastNameValue = "Potter";
        String fullNameValue = firstNameValue + " " + lastNameValue;

        bankManagerPage.clickCustomersElement();
        CustomersPage customersPage = new CustomersPage(driver);
        customersPage.searchCustomers(lastNameValue);
        customersPage.deleteCustomer();

        indexPage.clickHomePageButton();
        indexPage.clickCustomerLogin();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        customerLoginPage.selectCustomerNameList();
        Assert.assertFalse(customerLoginPage.isCustomerPresent(fullNameValue),
                "Customer '" + fullNameValue + "' was still found, but it should have been deleted!");
    }
}
