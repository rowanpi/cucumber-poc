package org.jembi.cucumber.example.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

    private static final String BSIS_HOME_PAGE = "http://127.0.0.1:9000/#/home";
    private static final String BSIS_LOGIN_PAGE = "http://127.0.0.1:9000/#/login";
    private WebDriver driver = null;

    @Given("^I navigate to the BSIS login page$")
    public void i_navigate_to_the_BSIS_login_page() throws Throwable {
      System.setProperty("webdriver.chrome.driver", "/home/rowan/jembiWorkspace/cucumber-poc/src/main/resources/chromedriver");
      driver= new ChromeDriver();
      driver.navigate().to(BSIS_LOGIN_PAGE);
      WebDriverWait wait = new WebDriverWait(driver, 15, 100);
      wait.until(AdditionalConditions.angularHasFinishedProcessing());
    }

    @When("^I populate the login form$")
    public void i_populate_the_login_form() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      System.out.println(driver.getPageSource());
      driver.findElement(By.name("username")).sendKeys("superuser");
      driver.findElement(By.name("password")).sendKeys("superuser");
    }
    
    @When("^I click the login button$")
    public void i_click_login_the_login_button() throws Throwable {
      driver.findElement(By.className("btn")).click();
      WebDriverWait wait = new WebDriverWait(driver, 15, 100);
      wait.until(AdditionalConditions.angularHasFinishedProcessing());
    }

    @Then("^I should be on the home page$")
    public void i_should_be_on_the_home_page() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      Assert.assertTrue(driver.getCurrentUrl().equals(BSIS_HOME_PAGE), "Not on home page");
    }
}
