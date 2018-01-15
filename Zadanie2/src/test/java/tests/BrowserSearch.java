package tests;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserSearch {

    protected WebDriver driver;

    final static Logger logger = Logger.getLogger(BrowserSearch.class);


    protected void doTest() {

        logger.info("TEST START");
        try {

            String baseUrl = "http://google.com";
            String input = "intive";
            String intiveUrl = "https://www.intive.com";
            String webElementClassNameToUrl = "_Rm";

            openBrowserWithUrl(driver, baseUrl);
            logger.info("Open Google website");
            searchIntive(driver, input);
            logger.info("Search for intive");
            WebElement firstElement = getFirstElement(driver, webElementClassNameToUrl);
            logger.info("Search for first element result");
            Assert.assertTrue(firstElement.getText().contains(intiveUrl));
            driver.quit();
            logger.info("Close browser");
        } catch (Exception ex) {
            logger.error("Oops, something went wrong!", ex);

        }
        logger.info("TEST END");
    }

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
