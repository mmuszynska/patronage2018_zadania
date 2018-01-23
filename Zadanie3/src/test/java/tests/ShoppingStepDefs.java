package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.Assert.assertEquals;
import static tests.Hooks.driver;
import static tests.Hooks.wait;

public class ShoppingStepDefs {

    @Given("^user is registered and logged in to the application$")
    public void userIsRegisteredAndLoggedInToTheApplication() {
        String login = "konto@do.testu";
        String password = "password";

        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys(login);
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys(password);
        driver.findElement(By.id("SubmitLogin")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("body#my-account")));
        assertEquals(true, driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=my-account"));
    }

    @When("^user clicks 'Home' button$")
    public void userClicksHomeButton() {
        driver.findElement(By.cssSelector("li > a.btn.btn-default.button.button-small > span")).click();
    }

    @When("^user provides search phase$")
    public void userProvideSearchPhase() {
        driver.findElement(By.name("search_query")).sendKeys("Blouse");
        driver.findElement(By.name("submit_search")).click();
    }

    @Then("^user should see search results$")
    public void userShouldSeeSearchResults() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product-container")));
        assertEquals(false, driver.findElements(By.className("product-container")).isEmpty());
    }

    @When("^user adds to cart first item on the page$")
    public void userAddsToCartFirstItemOnThePage() {
        driver.findElement(By.className("icon-th-list")).click();
// change view from grid to list
        driver.findElement(By.linkText("Add to cart")).click();
    }

    @Then("^user can see 'there is an item added to cart' message$")
    public void userCanSeeThereIsAnItemAddedToCartMessage() {
        assertEquals(true, driver.getPageSource().contains("Product successfully added to your shopping cart"));
    }

    @And("^user proceeds to checkout$")
    public void userProceedsToCheckout() {
        assertEquals(true, driver.getPageSource().contains("Proceed to checkout"));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")));
        element.click();
    }

    @And("^user proceeds from summary to checkout$")
    public void userProceedsFromSummaryToCheckout() {
        driver.findElement(By.cssSelector("a.button.btn.btn-default.standard-checkout.button-medium > span")).click();
    }

    @And("^user proceeds from address to checkout$")
    public void userProceedsFromAddressToCheckout() {
        driver.findElement(By.name("processAddress")).click();
    }

    @And("^user agrees to TOS$")
    public void userAgreesToTOS() {
        WebElement tosCheck = driver.findElement(By.id("cgv"));
        if (!tosCheck.isSelected()) {
            tosCheck.click();
        }
    }

    @And("^user proceeds from shipping to checkout$")
    public void userProceedsFromShippingToCheckout() {
        driver.findElement(By.name("processCarrier")).click();
    }

    @And("^user selects 'Pay by bank wire' payment method$")
    public void userSelectsPayByBankWirePaymentMethod() {
        driver.findElement(By.linkText("Pay by bank wire (order processing will be longer)")).click();
    }

    @And("^user confirms an order$")
    public void userConfirmsAnOrder() {
        driver.findElement(By.cssSelector("button.button.btn.btn-default.button-medium")).click();
    }

    @And("^user clicks 'Back to orders'$")
    public void userClicksBackToOrders() {
        assertEquals(true, driver.getPageSource().contains("Your order on My Store is complete."));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Back to orders")));
        element.click();
    }

    @Then("^user is redirected to the order history$")
    public void userIsRedirectedToTheOrderHistory() {
        assertEquals(true, driver.getCurrentUrl().equals("http://automationpractice.com/index.php?controller=history"));
    }

    @When("^user clicks 'Details'$")
    public void userClicksDetails() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Details")));
        element.click();
    }

    @Then("^user can see details of his orders$")
    public void userCanSeeDetailsOfHisOrders() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.page-heading:nth-child(3)")));
        assertEquals(true, driver.getPageSource().contains("Follow your order's status step-by-step"));
    }

    @And("^user selects 'Pay by cheque' payment method$")
    public void userSelectsPayByChequePaymentMethod() {
        driver.findElement(By.cssSelector("a.cheque > span")).click();
    }
}
