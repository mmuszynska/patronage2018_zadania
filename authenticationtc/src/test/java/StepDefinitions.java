import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import gherkin.formatter.model.Examples;
import gherkin.formatter.model.ScenarioOutline;

public class StepDefinitions {
    @Given("^user is registered$")
    public void userIsRegistered(DataTable arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
    @Given("^user is on the login page$")
    public void userIsOnTheLoginPage() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
    @When("^user enters valid credentials$")
    public void userEntersValidCredentials(DataTable args) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^clicks the 'Log In' button$")
    public void clicksTheLogInButton1() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^user is redirected to the page with an account details view$")
    public void userIsRedirectedToThePageWithAnAccountDetailsView() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^user enters the correct login$")
    public void userEntersTheCorrectLogin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^user enters the wrong password or none password$")
    public void userEntersTheWrongPasswordOrNonePassword(DataTable args) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^clicks the 'Log in' button$")
    public void clicksTheLogInButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^user enters no login$")
    public void userEntersNoLogin(DataTable args) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^user enters no password$")
    public void userEntersNoPassword(DataTable args) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^'Authentication failed. Login or password are incorrect' message should be displayed$")
    public void authenticationFailedLoginOrPasswordAreIncorrectMessageShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Given("^user is not registered$")
    public void userIsNotRegistered() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^user enters any login$")
    public void userEntersAnyLogin() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @And("^user enters any password$")
    public void userEntersAnyPassword() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^user enters an invalid login$")
    public void userEntersAnInvalidLogin(DataTable args) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^some relevant validation message should be displayed$")
    public void someRelevantValidationMessageShouldBeDisplayed() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^user enters a valid \"([^\"]*)\" in the login field$")
    public void userEntersAValidInTheLoginField(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the \"([^\"]*)\" is 'System should accept'$")
    public void theIsSystemShouldAccept(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^user enters an invalid \"([^\"]*)\" in the login field$")
    public void userEntersAnInvalidInTheLoginField(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^the \"([^\"]*)\" is 'System should not accept'$")
    public void theIsSystemShouldNotAccept(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }
}
