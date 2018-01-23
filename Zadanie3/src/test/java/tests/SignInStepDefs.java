package tests;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static tests.Hooks.driver;
import static tests.Hooks.wait;

public class SignInStepDefs {

    @Given("^user is registered in the application with valid login and password$")
    public void UserIsRegistered() {
//        User is registered manually
    }

    @When("^user clicks 'Sign in' button$")
    public void userClicksSignInButton() {
        driver.findElement(By.linkText("Sign in")).click();
    }

    @And("^user enters login \"([^\"]*)\"$")
    public void userEntersLogin(String login) {
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(login);
    }

    @And("^user enters password \"([^\"]*)\"$")
    public void userEntersPassword(String password) {
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    @And("^submit form with the 'Sign in' button$")
    public void submitFormWithTheSignInButton() {
        driver.findElement(By.id("SubmitLogin")).click();
    }

    @Then("^user is redirected to 'My account page'$")
    public void userIsRedirectedToMyAccountPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body#my-account")));
        assertEquals(true, driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account"));
    }

    @When("^user clicks 'My personal information'$")
    public void userClicksMyPersonalInformation() {
        driver.findElement(By.cssSelector("a[title=\"Information\"] > span")).click();
    }

    @Then("^user can see the correct data such as first name, last name, email address and date of birth$")
    public void userCanSeeTheCorrectData() {
        assertEquals(true, driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=identity"));
        driver.findElement(By.id("firstname"));
        driver.findElement(By.id("lastname"));
        driver.findElement(By.id("email"));
        //BELOW IS "BACK TO YOUR ACCOUNT" STEP
        driver.findElement(By.cssSelector("li > a.btn.btn-default.button.button-small > span")).click();
    }

    @Then("^user can see relevant validation message: \"([^\"]*)\"$")
    public void userCanSeeRelevantValidationMessage(String error_message) {
        System.out.println(error_message);

    }

}
