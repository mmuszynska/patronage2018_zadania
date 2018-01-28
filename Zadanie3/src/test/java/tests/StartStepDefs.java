package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.apache.log4j.Logger;
import pages.StartPage;

import static org.junit.Assert.assertEquals;
import static tests.Hooks.driver;

public class StartStepDefs {

    final static Logger logger = Logger.getLogger(StartStepDefs.class);

    StartPage startPage = new StartPage();
    String mainPageUrl = "http://automationpractice.com/index.php";

    @Given("^user is on the main page$")
    public void userIsOnTheMainPage() {
        logger.info("TEST START - User is on the main page");
        driver.get(mainPageUrl);
        assertEquals(true, driver.getCurrentUrl().equals(mainPageUrl));
    }

    @And("^user is not authenticated$")
    public void userIsNotAuthenticated() {
        assertEquals("Sign in", startPage.noUserLoggedIn.getText());
    }
}
