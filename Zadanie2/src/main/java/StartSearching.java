import browsers.ChromeTest;
import browsers.FirefoxTest;

public class StartSearching {
    public static void main(String[] args) {
        ChromeTest chromeTest = new ChromeTest();
        FirefoxTest firefoxTest = new FirefoxTest();

        chromeTest.executeScript();
        firefoxTest.executeScript();
    }
}