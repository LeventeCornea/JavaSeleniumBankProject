package pageLocators;

import org.openqa.selenium.By;

public class CustomerAccountTransactionsLocators {
    public static final By backButton = By.xpath("//button[@ng-click='back()']");
    public static final By transactionData = By.id("//td[@class='ng-binding']");
    public static final By resetButton = By.xpath("//button[@ng-click='reset()']");
}
