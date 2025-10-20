package helpMethods;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.Map;

public class UIHelper {

    public static void validateCssProperties(WebElement element, Map<String, String> expectedProperties) {
        for (Map.Entry<String, String> entry : expectedProperties.entrySet()) {
            String property = entry.getKey();
            String expectedValue = entry.getValue();
            String actualValue = element.getCssValue(property);

            Assert.assertEquals(actualValue, expectedValue,
                    "Mismatch for CSS property: " + property +
                            " | Expected: " + expectedValue +
                            " | Found: " + actualValue);
        }
    }
}
