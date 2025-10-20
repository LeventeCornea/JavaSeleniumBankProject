package tests.accountLoginTests.functional.customerAccountsLogin;

import pages.CustomerAccountPage;
import sharedData.SharedData;

import org.testng.annotations.Test;
import pages.CustomerLoginPage;
import pages.IndexPage;

import java.awt.*;

public class LoggingInWithExistingCustomersAccountTest extends SharedData {

    @Test
    public void testMethod() throws AWTException {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickCustomerLogin();
        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);
        CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);

        String[] firstNameValue = {"Harry", "Ron", "Neville"};
        String[] lastNameValue = {"Potter", "Weasly", "Longbottom"};
        String[] fullNameValue = new String[firstNameValue.length];
        for (int i = 0; i < firstNameValue.length; i++) {
            fullNameValue[i] = firstNameValue[i] + " " + lastNameValue[i];
        }

        for (int i = 0; i < fullNameValue.length; i++) {
            customerLoginPage.selectCustomerName(fullNameValue[i]);
            customerLoginPage.selectLoginButton();
            customerAccountPage.selectLogoutButton();
        }
    }
}
