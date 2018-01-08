package browsers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class FirefoxTest {
    public void executeScript() {

//        System.setProperty("webdriver.gecko.driver", "C:\\bin\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement element = driver.findElement(By.id("lst-ib"));
        element.sendKeys("intive");
        element.submit();

        WebElement myText = driver.findElement(By.xpath("//*[@id='rso']/div[1]/div/div/div/div/div/div/div/cite"));
        String text = myText.getText();
        System.out.println("Text value " + text);
        if (text.contains("https://www.intive.com")) {
            System.out.println("Valid verification. First search result is a reference to site https:/www.intive.com");
        } else {
            System.out.println("Invalid verification. First search result is not a reference to site https://www.intive.com");
        }

        driver.quit();
    }
}
