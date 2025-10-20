package pageLocators;

import org.openqa.selenium.By;

public class IndexLocators {
    public static final By bankManagerLoginMenu = By.xpath("//button[normalize-space()='Bank Manager Login']");
    public static final By customerLoginMenu = By.xpath("//button[normalize-space()='Customer Login']");
    public static final By homePageButton = By.xpath("//button[normalize-space()='Home']");
    public static final By logo = By.xpath(".//strong");
    public static final By topBackgroundDisplayed = By.xpath("//div[@class='box mainhdr']");
    public static final By mainBackgroundDisplayed = By.xpath("borderM box padT20");
    public static final By header = By.xpath("box mainhdr");
    public static final By contentWindow = By.xpath("borderM box padT20");
}
