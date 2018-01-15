package tests;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeSearch extends BrowserSearch {

    @Test
    public void runTest(){
        driver = new ChromeDriver();
        doTest();
    }
}