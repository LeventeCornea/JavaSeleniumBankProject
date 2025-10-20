package tests.bankManagerTests.negativeCases.invalidAccountsCreation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BankManagerPage;
import pages.IndexPage;
import pages.OpenAccountPage;
import sharedData.SharedData;

import java.awt.*;

public class OpenNamelessAccountTest extends SharedData {

    @Test
    public void testMethod() throws AWTException {

        String currencyValue = "Dollar";

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickOpenAccountElement();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectCurrency(currencyValue);
        openAccountPage.selectButton2();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(openAccountPage.isOpenCustomerButtonDisplayed(), "Account is not opened without customer's name!");
    }
}
