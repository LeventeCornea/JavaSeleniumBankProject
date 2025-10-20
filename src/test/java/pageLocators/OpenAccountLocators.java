package pageLocators;

import org.openqa.selenium.By;

public class OpenAccountLocators {
    public static final By customerNameElement = By.cssSelector("#userSelect");
    public static final By currencyElement = By.cssSelector("#currency");
    public static final By processButton = By.cssSelector("button[type='submit']");
    public static final By currenciesList = By.xpath("//div[@class='form-group']");
}
