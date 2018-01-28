package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static tests.Hooks.driver;

public class OrderHistoryPage {

    @FindBy(how = How.LINK_TEXT, using = "Details")
    public WebElement orderDetails;

    @FindBy(how = How.ID, using = "block-order-detail")
    public WebElement ordersStatus;

    public OrderHistoryPage() {
        PageFactory.initElements(driver, this);
    }
}
