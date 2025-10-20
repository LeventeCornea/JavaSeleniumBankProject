package tests.customerAccountsTests.functionalCustomerAccountPageTests.customerAccountIDsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerLoginPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.util.List;
import java.awt.*;

public class ExistingCustomersAccountsIDsTest extends SharedData {

    @Test
    public void testMethod() throws AWTException {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickCustomerLogin();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        String[] firstNameValue = {"Harry", "Ron", "Neville"};
        String[] lastNameValue = {"Potter", "Weasly", "Longbottom"};
        String[] fullNameValue = new String[firstNameValue.length];
        for (int i = 0; i < firstNameValue.length; i++) {
            fullNameValue[i] = firstNameValue[i] + " " + lastNameValue[i];
        }

        for (int i = 0; i < fullNameValue.length; i++) {
            customerLoginPage.selectCustomerName(fullNameValue[i]);
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

                Assert.assertEquals(selected, accountNumber, "Account number does not match!");
            }
            CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);
            customerAccountPage.selectLogoutButton();
        }
    }
}
