package tests.bankManagerTests.negativeCases.invalidAccountsCreation;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import sharedData.SharedData;

import java.awt.*;

public class CreateDuplicateCustomerWithAccountTest extends SharedData{

    @Test
    public void testMethod(){


        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerElement();

        String firstNameValue = "Levente";
        String lastNameValue = "Cornea";
        String postCodeValue = "251569";


        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);

        for (int i = 1; i <= 2; i++) {
            addCustomerPage.fillFirstName(firstNameValue);
            addCustomerPage.fillLastName(lastNameValue);
            addCustomerPage.fillPostCode(postCodeValue);
            addCustomerPage.clickAddCustomerButton2();

            String alertText = addCustomerPage.getAlertTextAndAccept();
            System.out.println("Attempt " + i + " → ALERT SAYS: " + alertText);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i == 1) {
                Assert.assertTrue(alertText.contains("Customer added successfully"),
                        "Expected success alert on first insert");
            } else {
                Assert.assertTrue(alertText.contains("Please check the details"),
                        "Expected duplicate warning on second insert");
            }
        }
    }
}
