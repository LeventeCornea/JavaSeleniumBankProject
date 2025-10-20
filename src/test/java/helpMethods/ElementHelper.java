package helpMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ElementHelper {

    public WebDriver driver;

    public ElementHelper(WebDriver driver){
        this.driver = driver;
    }
    public void waitForElementVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void clickLocator(By locator){
        waitForElementVisible(locator);
        driver.findElement(locator).click();
    }
    public void clickJSLocator(By locator){
        waitForElementVisible(locator);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", driver.findElement(locator));
    }
    public void fillLocator(By locator, String value) {
        waitForElementVisible(locator);
        driver.findElement(locator).sendKeys(value);
    }
    public void selectLocator(By locator, String value){
        waitForElementVisible(locator);
        Select elementSelect = new Select(driver.findElement(locator));
        elementSelect.selectByVisibleText(value);
    }
    public void validateContainTextLocator(By locator, String value){
        waitForElementVisible(locator);
        String text = driver.findElement(locator).getText();
        Assert.assertTrue(text.contains(value));
    }
    public void clearField(By locator) {
        waitForElementVisible(locator);
        WebElement element = driver.findElement(locator);
        element.clear();
    }
    public boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clearLocator(By locator) {
        driver.findElement(locator).clear();
    }
    public String getText(By locator) {
        waitForElementVisible(locator);
        return driver.findElement(locator).getText().trim();
    }
    public String getAttribute(By locator, String attribute) {
        waitForElementVisible(locator);
        return driver.findElement(locator).getAttribute(attribute).trim();
    }
    public String getValidationMessage(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getAttribute("validationMessage");
    }

}
