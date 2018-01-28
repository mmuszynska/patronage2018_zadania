package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static tests.Hooks.driver;

public class StartPage {

    @FindBy(how = How.CLASS_NAME, using = "header_user_info")
    public WebElement noUserLoggedIn;

    public StartPage() {
        PageFactory.initElements(driver, this);
    }

}
