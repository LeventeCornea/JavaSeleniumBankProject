package tests.accountLoginTests.functional.customerAccountsLogin;

import org.testng.annotations.Test;
import pages.CustomerLoginPage;
import pages.CustomerAccountPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.awt.*;

public class LoggingInWithExistingCustomerAccountTest extends SharedData {

    @Test
    public void testMethod() throws AWTException {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickCustomerLogin();

        String firstNameValue = "Harry";
        String lastNameValue = "Potter";
        String fullNameValue = firstNameValue+" "+lastNameValue;

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);

        customerLoginPage.selectCustomerName(fullNameValue);
        customerLoginPage.selectLoginButton();
        customerAccountPage.selectLogoutButton();
    }
}
