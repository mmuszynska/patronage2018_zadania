package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest extends BrowserTest {

    @Test
    public void runTest(){
        driver = new ChromeDriver();
        doTest();
    }
}