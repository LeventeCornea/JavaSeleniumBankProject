package pages;

import helpMethods.AlertHelper;
import helpMethods.ElementHelper;
import org.openqa.selenium.WebDriver;
import pageLocators.CustomerAccountTransactionsLocators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CustomerAccountTransactionsPage {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private AlertHelper alertHelper;
    private By transactionsTable = By.xpath("//table[@class='table table-bordered table-striped']/tbody/tr");


    public CustomerAccountTransactionsPage(WebDriver driver){
        this.driver = driver;
        elementHelper = new ElementHelper(driver);
    }
    public void selectBackButton(){
        elementHelper.clickJSLocator(CustomerAccountTransactionsLocators.backButton);
    }
    public String getCurrentTransactionDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy h:mm a");
        return LocalDateTime.now().format(formatter);
    }
    public void validateCustomerData(String expectedDate, String depositSum, String transactionType) {
        List<WebElement> rows = driver.findElements(By.xpath("//tr[@class='ng-scope']"));
        if (rows.isEmpty()) throw new AssertionError("No transactions found!");

        WebElement lastRow = rows.get(rows.size() - 1);
        List<WebElement> cells = lastRow.findElements(By.xpath(".//td[@class='ng-binding']"));

        String actualDateText = cells.get(0).getText().trim();
        String actualSum = cells.get(1).getText().trim();
        String actualType = cells.get(2).getText().trim();

        String actualDateFormatted = normalizeDate(actualDateText);
        String expectedDateFormatted = normalizeDate(expectedDate);

        Assert.assertEquals(actualDateFormatted, expectedDateFormatted,
                "Transaction date does not match");
        Assert.assertEquals(actualSum, depositSum,
                "Expected deposit sum " + depositSum + " but found " + actualSum);
        Assert.assertEquals(actualType, transactionType,
                "Expected transaction type " + transactionType + " but found " + actualType);
    }

    private String normalizeDate(String dateText) {
        Locale[] locales = {Locale.ENGLISH, new Locale("hu")};
        SimpleDateFormat outputFormat = new SimpleDateFormat("MMM d, yyyy h:mm a", Locale.ENGLISH);
        String[] inputPatterns = {"MMM d, yyyy h:mm:ss a", "MMM d, yyyy h:mm a"};

        for (Locale locale : locales) {
            for (String pattern : inputPatterns) {
                try {
                    SimpleDateFormat parser = new SimpleDateFormat(pattern, locale);
                    Date date = parser.parse(dateText);
                    return outputFormat.format(date);
                } catch (ParseException ignored) {
                }
            }
        }
        throw new AssertionError("Failed to parse date: " + dateText);
    }

    public void validateTransactionRow(String transactionDate, String s, String transactionType) {

    }
    public void validateDateAndSumvalidateDateAndSum(String transactionDate, String s){

    }
    public void validateTransactionSum(String s){

    }

    public boolean isCustomerRowDisplayed(){
        return elementHelper.isElementDisplayed(CustomerAccountTransactionsLocators.transactionData);
    }
    public void selectResetButton(){
        elementHelper.clickJSLocator(CustomerAccountTransactionsLocators.resetButton);
    }
}
