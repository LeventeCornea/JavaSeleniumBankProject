package pageLocators;

import org.openqa.selenium.By;

public class CustomerLoginLocators {
    public static final By customersList = By.id("userSelect");
    public static final By loginButton = By.xpath("//button[normalize-space()='Login']");
    public static final By customerOptions = By.cssSelector("#userSelect option");
}
