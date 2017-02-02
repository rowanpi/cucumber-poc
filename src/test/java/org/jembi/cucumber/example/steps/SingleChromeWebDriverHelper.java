package org.jembi.cucumber.example.steps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingleChromeWebDriverHelper {
  private static SingleChromeWebDriverHelper instance;
  private WebDriver driver;

  private SingleChromeWebDriverHelper() {
    System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver");
    driver= new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
  }

  public static SingleChromeWebDriverHelper getInstance(boolean forceReload) {
    if (instance == null || forceReload) {
        instance = new SingleChromeWebDriverHelper();
    }
    return instance;
  }

  public WebDriver getDriver() {
     return driver;
  }
}
