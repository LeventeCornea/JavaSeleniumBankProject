package pageLocators;

import org.openqa.selenium.By;

public class CustomersLocators {
    public static final By customerName = By.xpath("//input[@placeholder='Search Customer']");
    public static final By customerRow = By.xpath("//tr[@class='ng-scope']");
    public static final By deleteButton = By.xpath("//button[@ng-click='deleteCust(cust)']");
}
