package tests.customerAccountsTests.functionalCustomerAccountPageTests.customerAccountIDsTests;

import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerLoginPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.util.List;
import java.awt.*;

public class ExistingCustomerAccountIDsTest extends SharedData {

    @Test
    public void testMethod() throws AWTException {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickCustomerLogin();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        String firstNameValue = "Harry";
        String lastNameValue = "Potter";
        String fullNameValue = firstNameValue+" "+lastNameValue;

        customerLoginPage.selectCustomerName(fullNameValue);
        customerLoginPage.selectLoginButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CustomerAccountPage accountPage = new CustomerAccountPage(driver);

        List<String> allAccounts = accountPage.getAllAccountNumbers();

        System.out.println("All accounts for " + fullNameValue + ": " + allAccounts);

        for (String accountNumber : allAccounts) {
            accountPage.selectAccountNumber(accountNumber);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            String selected = accountPage.getSelectedAccountNumber();
            System.out.println("Selected account: " + selected);

        }
        CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);
        customerAccountPage.selectLogoutButton();
    }
}
