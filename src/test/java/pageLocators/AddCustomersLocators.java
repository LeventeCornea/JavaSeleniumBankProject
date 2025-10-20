package pageLocators;

import org.openqa.selenium.By;

public class AddCustomersLocators {
    public static final By firstNameElement = By.cssSelector("input[placeholder='First Name']");
    public static final By lastNameElement = By.cssSelector("input[placeholder='Last Name']");
    public static final By postCodeElement = By.cssSelector("input[placeholder='Post Code']");
    public static final By addCustomerButton = By.cssSelector("button[type='submit']");
}
