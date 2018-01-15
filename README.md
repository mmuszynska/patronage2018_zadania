Task 2 - sample project demonstrating how to test Google search UI with Selenium WebDriver and Maven



## Prerequisites

* **Mozilla Firefox Web Browser**, you can download 57.0.4 version [here](https://www.mozilla.org/pl/firefox/)
* **Google Chrome Web Browser**, you can download 63.0.3239.132 version [here](https://www.google.pl/chrome/browser/desktop/index.html)
* **Java**, you can download jdk-9 version [here](http://www.oracle.com/technetwork/java/javase/downloads/jdk9-downloads-3848520.html)
* **geckodriver.exe**, you can download v.0.19.1 version [here](https://github.com/mozilla/geckodriver/releases)
* **chromedriver.exe**, you can download 2.34 version [here](https://chromedriver.storage.googleapis.com/index.html?path=2.34/)

You have to set up the environment variables path for geckodriver.exe and chromedriver.exe. There are helpful steps below on how to do it in Windows:

1. Right click on 'Computer'
2. Click on 'Properties'
3. Click on 'Advanced system settings'
4. Click on 'Environment variables'
5. Copy path where -driver.exe are installed
6. On an 'Environment variables' window click 'New' under 'System variables' and set path (if path already exists, then click 'Edit')

It's possible to put a location of -driver.exe files manually, e.g.:

```java
System.setProperty("webdriver.gecko.driver", "C:\\bin\\geckodriver.exe");
System.setProperty("webdriver.chrome.driver", "C:\\bin\\chromedriver.exe");
```

## Dependencies and Properties

| name                   | version                                  |
| :--------------------- | :--------------------------------------- |
| selenium-java          | [3.8.1](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.8.1) |
| junit                  | [4.12](https://mvnrepository.com/artifact/junit/junit/4.12) |
| log4j                  | [1.2.17](https://mvnrepository.com/artifact/log4j/log4j/1.2.17) |
| maven.compiler.source* | 1.8                                      |
| maven.compiler.target* | 1.8                                      |

If you see a warning message produced by the Java compiler:

> warning: [options] source value 1.5 is obsolete and will be removed in a future release

Add the above properties*. It appears when you use a newer version of the JDK to an older target version.

## Running test from command console

1. Go to the project main directory
2. Run Run.sh
3. Now your test should start running



#### Run.sh file

```
mvn test
```

## Author

```
Małgorzata Muszyńska
```

