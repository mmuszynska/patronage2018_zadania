package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import static tests.Hooks.driver;

public class BackgroundStepsDefs {

    @Given("^user is not authenticated$")
    public void userIsNotAuthenticated() {
        WebElement area = driver.findElement(By.className("header_user_info"));
        assertEquals("Sign in", area.getText());
    }

    @And("^user is on the main page$")
    public void userIsOnTheMainPage() {
        assertEquals(true, driver.getCurrentUrl().equals("http://automationpractice.com/index.php"));

    }
}
