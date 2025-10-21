package tests.bankManagerTests.negativeCases.invalidAccountsCreation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BankManagerPage;
import pages.IndexPage;
import pages.OpenAccountPage;
import sharedData.SharedData;

import java.awt.*;

public class OpenNonExistingAccountTest extends SharedData {

    @Test
    public void testMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickOpenAccountElement();

        OpenAccountPage openAccountPage = new OpenAccountPage(driver);
        openAccountPage.selectButton2();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(openAccountPage.isOpenCustomerButtonDisplayed(), "Expected browser validation message was displayed!");
    }
}
