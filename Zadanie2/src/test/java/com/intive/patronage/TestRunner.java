package com.intive.patronage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ChromeTest;
import tests.FirefoxTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ChromeTest.class,
        FirefoxTest.class
})

public class TestRunner {

}
