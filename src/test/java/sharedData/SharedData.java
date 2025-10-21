package sharedData;

import loggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.IndexPage;

public class SharedData {

    public WebDriver driver;
    public String testName;
    public IndexPage indexPage;

    @BeforeMethod
    public void prepareEnvironment(){
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir=/tmp/chrome-user-data-" + System.currentTimeMillis());

        driver = new ChromeDriver(options);
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
        driver.manage().window().maximize();

        testName = this.getClass().getSimpleName();
        LoggerUtility.startTest(testName);
    }

    @AfterMethod
    public void clearEnvironment(){
        if(driver != null){
            driver.quit();
        }
    }
}
