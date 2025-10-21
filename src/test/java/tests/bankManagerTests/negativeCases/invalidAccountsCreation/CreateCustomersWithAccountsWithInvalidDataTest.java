package tests.bankManagerTests.negativeCases.invalidAccountsCreation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddCustomerPage;
import pages.BankManagerPage;
import pages.IndexPage;
import sharedData.SharedData;

import java.awt.*;
import java.awt.event.KeyEvent;

public class CreateCustomersWithAccountsWithInvalidDataTest extends SharedData {

    @Test
    public void testMethod(){

        IndexPage indexPage = new IndexPage(driver);
        indexPage.clickManagerLoginMenu();

        BankManagerPage bankManagerPage = new BankManagerPage(driver);
        bankManagerPage.clickAddCustomerElement();

        String firstNameValue1 = "3525H%";
        String firstNameValue2 = "Levente";
        String lastNameValue1 = "$lv2/";
        String lastNameValue2 = "Cornea";
        String postCodeValue1 = "Levente";
        String postCodeValue2 = "558877";

        AddCustomerPage addCustomerPage = new AddCustomerPage(driver);
        addCustomerPage.fillFirstName(firstNameValue1);
        addCustomerPage.fillLastName(lastNameValue1);
        addCustomerPage.fillPostCode(postCodeValue1);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();

        String alertText1 = addCustomerPage.getAlertTextAndAccept();
        System.out.println(" → ALERT SAYS: " + alertText1);

        addCustomerPage.fillFirstName(firstNameValue1);
        addCustomerPage.fillLastName(lastNameValue1);
        addCustomerPage.fillPostCode(postCodeValue2);
        actions.sendKeys(Keys.ENTER).perform();

        String alertText2 = addCustomerPage.getAlertTextAndAccept();
        System.out.println(" → ALERT SAYS: " + alertText2);

        addCustomerPage.fillFirstName(firstNameValue2);
        addCustomerPage.fillLastName(lastNameValue1);
        addCustomerPage.fillPostCode(postCodeValue1);
        actions.sendKeys(Keys.ENTER).perform();

        String alertText3 = addCustomerPage.getAlertTextAndAccept();
        System.out.println(" → ALERT SAYS: " + alertText3);

        addCustomerPage.fillFirstName(firstNameValue1);
        addCustomerPage.fillLastName(lastNameValue2);
        addCustomerPage.fillPostCode(postCodeValue1);
        actions.sendKeys(Keys.ENTER).perform();

        String alertText4 = addCustomerPage.getAlertTextAndAccept();
        System.out.println(" → ALERT SAYS: " + alertText4);

        addCustomerPage.fillFirstName(firstNameValue2);
        addCustomerPage.fillLastName(lastNameValue2);
        addCustomerPage.fillPostCode(postCodeValue1);
        actions.sendKeys(Keys.ENTER).perform();

        String alertText5 = addCustomerPage.getAlertTextAndAccept();
        System.out.println(" → ALERT SAYS: " + alertText5);

        addCustomerPage.fillFirstName(firstNameValue1);
        addCustomerPage.fillLastName(lastNameValue2);
        addCustomerPage.fillPostCode(postCodeValue2);
        actions.sendKeys(Keys.ENTER).perform();

        String alertText6 = addCustomerPage.getAlertTextAndAccept();
        System.out.println(" → ALERT SAYS: " + alertText6);

        addCustomerPage.fillFirstName(firstNameValue2);
        addCustomerPage.fillLastName(lastNameValue1);
        addCustomerPage.fillPostCode(postCodeValue2);
        actions.sendKeys(Keys.ENTER).perform();

        String alertText7 = addCustomerPage.getAlertTextAndAccept();
        System.out.println(" → ALERT SAYS: " + alertText7);

        Assert.assertFalse(alertText1.contains("Customer added successfully"),
                "Accounts are opened, however the formats for the entered data are invalid");
        Assert.assertFalse(alertText2.contains("Customer added successfully"),
                "Accounts are opened, however the formats for the entered data are invalid");
        Assert.assertFalse(alertText3.contains("Customer added successfully"),
                "Accounts are opened, however the formats for the entered data are invalid");
        Assert.assertFalse(alertText4.contains("Customer added successfully"),
                "Accounts are opened, however the formats for the entered data are invalid");
        Assert.assertFalse(alertText5.contains("Customer added successfully"),
                "Accounts are opened, however the formats for the entered data are invalid");
        Assert.assertFalse(alertText6.contains("Customer added successfully"),
                "Accounts are opened, however the formats for the entered data are invalid");
        Assert.assertFalse(alertText7.contains("Customer added successfully"),
                "Accounts are opened, however the formats for the entered data are invalid");
    }
}
