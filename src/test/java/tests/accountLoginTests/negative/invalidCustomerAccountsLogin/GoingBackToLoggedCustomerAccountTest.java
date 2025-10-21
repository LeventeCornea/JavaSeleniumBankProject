package tests.accountLoginTests.negative.invalidCustomerAccountsLogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerLoginPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.awt.*;

public class GoingBackToLoggedCustomerAccountTest extends SharedData {

    @Test
    public void testMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickCustomerLogin();

        String firstNameValue = "Harry";
        String lastNameValue = "Potter";
        String fullNameValue = firstNameValue+" "+lastNameValue;

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        customerLoginPage.selectCustomerName(fullNameValue);
        customerLoginPage.selectLoginButton();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        indexPage.clickHomePageButton();
        indexPage.clickCustomerLogin();

        CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);

        Assert.assertTrue(customerAccountPage.isAccountPageDisplayed(), "Customer should be still logged in");
    }
}
