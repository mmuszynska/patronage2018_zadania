package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.MyAccountPage;
import pages.SignInPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static tests.Hooks.driver;
import static tests.StartStepDefs.logger;

public class SignInStepDefs {

    SignInPage signInPage = new SignInPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    String mainPageUrl = "http://automationpractice.com/index.php";
    String myAccountUrl = "http://automationpractice.com/index.php?controller=my-account";

    @Given("^user is registered in the application with email \"([^\"]*)\"$")
    public void userIsRegisteredInTheApplicationWithEmail(String email) {
        assertEquals(true, driver.getCurrentUrl().equals(mainPageUrl));
    }

    @When("^user clicks Sign in button$")
    public void userClicksButton() {
        signInPage.signInLink();
    }

    @And("^user enters email \"([^\"]*)\"$")
    public void userEntersEmail(String email) {
        signInPage.sendEmail(email);
    }

    @And("^user enters password \"([^\"]*)\"$")
    public void userEntersPassword(String password) {
        signInPage.sendPassword(password);
    }

    @And("^submit form with the Sign in button$")
    public void submitFormWithTheButton() {
        signInPage.logIn();
    }

    @And("^user can see the correct data in My personal information page$")
    public void userCanSeeTheCorrectDataInMyPersonalInformationPage() {
        myAccountPage.getMyPersonalInfPage();
        String name = myAccountPage.getNameFieldText();
        String lastName = myAccountPage.getSurnameFieldText();
        String email = myAccountPage.getEmailFieldText();
        assertFalse(name.isEmpty() && lastName.isEmpty() && email.isEmpty());
        logger.info("TEST END - Successful authentication process");
    }

    @Then("^user is redirected to My account page$")
    public void userIsRedirectedToPage() {
        assertEquals(true, driver.getCurrentUrl().equals(myAccountUrl));
    }

    @Then("^user can see relevant validation message: \"([^\"]*)\"$")
    public void userCanSeeRelevantValidationMessage(String expectedErrorMessage) {
        String errorMessage = signInPage.getErrorMessage();
        System.out.println(errorMessage);
        assertTrue(errorMessage.contains(expectedErrorMessage));
        logger.info("TEST END - User is not authenticated");
    }
}
