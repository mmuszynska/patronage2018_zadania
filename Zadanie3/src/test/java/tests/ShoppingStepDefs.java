package tests;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static tests.Hooks.driver;
import static tests.Hooks.wait;
import static tests.StartStepDefs.logger;

public class ShoppingStepDefs {

    SearchProductPage searchProductPage = new SearchProductPage();
    SignInPage signInPage = new SignInPage();
    AddProductPage addProductPage = new AddProductPage();
    ProceedingPage proceedingPage = new ProceedingPage();
    OrderHistoryPage orderHistoryPage = new OrderHistoryPage();
    String historyUrl = "http://automationpractice.com/index.php?controller=history";
    String shopMessage = "Product successfully added to your shopping cart";
    String payByBankWire = "pay by bank wire";
    String payByCheck = "pay by check";

    @Given("^user is logged in to the application with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void userIsLoggedInToTheApplicationWithEmailAndPassword(String email, String password) {
        signInPage.signInLink();
        signInPage.sendEmail(email);
        signInPage.sendPassword(password);
        signInPage.logIn();
    }

    @When("^user searches shop page with phrase \"([^\"]*)\"$")
    public void userSearchesShopPageWithPhrase(String searchPhrase) {
        searchProductPage.getSearchResult(searchPhrase);
    }

    @And("^user adds product to cart$")
    public void userAddsProductToCart() {
        addProductPage.getListView();
        addProductPage.buyProduct();
        assertEquals(true, driver.getPageSource().contains(shopMessage));
    }

    @And("^user proceeds all steps of ordering$")
    public void userProceedsAllStepsOfOrdering() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedingPage.firstProceed)).click();
        proceedingPage.getSummaryProceed();
        proceedingPage.getAddressProceed();
        proceedingPage.getTosCheck();
        proceedingPage.getShippingProceed();
    }

    @And("^user selects \"([^\"]*)\"$")
    public void userSelectsPaymentMethod(String paymentMethod) {
        if (paymentMethod.equals(payByBankWire)) {
            proceedingPage.getPayByBankWire();
        } else if (paymentMethod.equals(payByCheck)) {
            proceedingPage.getPayByCheck();
        }
    }

    @And("^user confirms an order$")
    public void userConfirmsAnOrder() {
        proceedingPage.getConfirm();
    }

    @Then("^user can see \"([^\"]*)\" message$")
    public void userCanSeeMessage(String niceMessage) {
        System.out.println("*****" + niceMessage + "*****");
        assertTrue(!niceMessage.isEmpty());
    }

    @And("^user is able to see details of his orders in Order history page$")
    public void userIsAbleToSeeDetailsOfHisOrdersInOrderHistoryPage() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedingPage.backToOrdersButton)).click();
        assertEquals(true, driver.getCurrentUrl().equals(historyUrl));
        wait.until(ExpectedConditions.elementToBeClickable(orderHistoryPage.orderDetails)).click();
        wait.until(ExpectedConditions.visibilityOf(orderHistoryPage.ordersStatus));
        assertTrue(orderHistoryPage.ordersStatus.isDisplayed());
        logger.info("TEST END - Successful shopping process");
    }
}


