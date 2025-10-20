package tests.customerAccountsTests.functionalCustomerAccountPageTests.customerAccountsDepositTests;

import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerAccountTransactionsPage;
import pages.CustomerLoginPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.awt.*;

public class ExistingCustomerWithAccountWithMultipleDepositsTest extends SharedData {
    @Test
    public void testMethod() throws AWTException {

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickCustomerLogin();

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        String firstNameValue = "Harry";
        String lastNameValue = "Potter";
        String fullNameValue = firstNameValue+" "+lastNameValue;
        String[] depositSum = {"50", "25", "125"};
        String transactionType = "Credit";

        customerLoginPage.selectCustomerName(fullNameValue);
        customerLoginPage.selectLoginButton();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CustomerAccountPage accountPage = new CustomerAccountPage(driver);
        CustomerAccountTransactionsPage customerAccountTransactionsPage = new CustomerAccountTransactionsPage(driver);

            for (int i = 0; i < depositSum.length; i++) {
                accountPage.selectDepositButton();
                accountPage.fillDepositAmount(depositSum[i]);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                accountPage.selectConfirmDepositButton();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                accountPage.selectTransactionsHistoryButton();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                String transactionDate = customerAccountTransactionsPage.getCurrentTransactionDate();
                customerAccountTransactionsPage.validateTransactionRow(transactionDate, depositSum[i], transactionType);
                customerAccountTransactionsPage.selectBackButton();
                }
            accountPage.selectTransactionsHistoryButton();
            customerAccountTransactionsPage.selectResetButton();
            CustomerAccountPage customerAccountPage = new CustomerAccountPage(driver);
            customerAccountPage.selectLogoutButton();
        }
    }
