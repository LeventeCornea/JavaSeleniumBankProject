package pageLocators;

import org.openqa.selenium.By;

public class CustomerAccountLocators {
    public static final By customerAccountNumber = By.id("accountSelect");
    public static final By transactionsHistoryButton = By.xpath("//button[@ng-class='btnClass1']");
    public static final By depositButton = By.xpath("//button[@ng-class='btnClass2']");
    public static final By depositAndWithdrawAmountField = By.xpath("//input[@ng-model='amount']");
    public static final By withdrawButton = By.xpath("//button[@ng-class='btnClass3']");
    public static final By confirmDepositAndWithdrawalButton = By.xpath("//button[@type='submit']");
    public static final By logoutButton = By.xpath("//button[normalize-space()='Logout']");
}
