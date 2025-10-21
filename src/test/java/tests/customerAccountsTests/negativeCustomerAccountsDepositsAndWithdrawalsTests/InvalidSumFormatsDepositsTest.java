package tests.customerAccountsTests.negativeCustomerAccountsDepositsAndWithdrawalsTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CustomerAccountPage;
import pages.CustomerAccountTransactionsPage;
import pages.CustomerLoginPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.awt.*;

public class InvalidSumFormatsDepositsTest extends SharedData {

    @Test
    public void testMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickCustomerLogin();

        String firstNameValue = "Harry";
        String lastNameValue = "Potter";
        String fullNameValue = firstNameValue+" "+lastNameValue;
        String[] depositSum = {"money", "r#!", "-50"};

        CustomerLoginPage customerLoginPage = new CustomerLoginPage(driver);

        customerLoginPage.selectCustomerName(fullNameValue);
        customerLoginPage.selectLoginButton();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        CustomerAccountPage accountPage = new CustomerAccountPage(driver);
        for (int i = 0; i<depositSum.length; i++) {
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
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            CustomerAccountTransactionsPage customerAccountTransactionsPage = new CustomerAccountTransactionsPage(driver);
            customerAccountTransactionsPage.validateTransactionSum(depositSum[i]);

            Assert.assertFalse(Boolean.parseBoolean(depositSum[i]), "Transactions table is empty");

            customerAccountTransactionsPage.selectBackButton();
        }
    }
}

