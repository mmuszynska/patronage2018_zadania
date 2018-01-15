package com.intive.patronage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.ChromeSearch;
import tests.FirefoxSearch;

@RunWith(Suite.class)
@Suite.SuiteClasses({ChromeSearch.class,
        FirefoxSearch.class
})

public class TestRunner {

}
