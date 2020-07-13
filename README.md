# BDD Cucumber
Behavior Driven Development with [Cucumber](www.cucumber.io) and [Java-a11y](https://github.com/sridharbandi/Java-a11y)

Leverage Cucumber and Java-a11y for 508 and Accessibility testing

# TL;DR
* clone the repo
* run tests with class `RunCukesTest` using maven in bash or your IDE test runner
```bash
mvn clean test
```
## WSL + VScode
If running on windows with WSL & VScode, be sure to swap the `WebDriverManager` for actual location of `chromedriver.exe` in `CukesWebDriverManager.java`
```java
//use this for WebDriverManager on desktop that has chrome 
  io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
//use this when you need to specify location of chromedriver
  System.setProperty("webdriver.chrome.driver", "/mnt/c/selenium/chromedriver_win32/chromedriver.exe")
```