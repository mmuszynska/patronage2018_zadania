package tests;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserTest {

    protected void doTest() {
        String baseUrl = "http://google.com";
        String input = "intive";
        String intiveUrl = "https://www.intive.com";
        String webElementClassNameToUrl = "_Rm";

        openBrowserWithUrl(driver, baseUrl);
        searchIntive(driver, input);
        WebElement firstElement = getFirstElement(driver, webElementClassNameToUrl);
        Assert.assertTrue(firstElement.getText().contains(intiveUrl));
        driver.quit();
    }

    protected WebDriver driver;

    protected void openBrowserWithUrl(WebDriver driver, String baseUrl) {
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void searchIntive(WebDriver driver, String input) {
        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys(input);
        element.submit();
    }

    protected WebElement getFirstElement(WebDriver driver, String webElementClassName) {
        List<WebElement> linkElements = driver.findElements(By.className(webElementClassName));
        return linkElements.get(0);
    }

}
