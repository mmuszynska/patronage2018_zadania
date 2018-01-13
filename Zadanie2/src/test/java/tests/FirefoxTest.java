package tests;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest extends BrowserTest {

    @Test
    public void runTest(){
        driver = new FirefoxDriver();
        doTest();
    }
}
