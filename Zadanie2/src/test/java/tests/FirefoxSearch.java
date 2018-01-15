package tests;

import org.junit.Test;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxSearch extends BrowserSearch {

    @Test
    public void runTest(){
        driver = new FirefoxDriver();
        doTest();
    }
}
