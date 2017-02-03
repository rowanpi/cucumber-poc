package org.jembi.cucumber.example.steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

    private static final String BSIS_HOME_PAGE = "http://127.0.0.1:9000/#/home";
    private static final String BSIS_LOGIN_PAGE = "http://127.0.0.1:9000/#/login";
    private WebDriver driver;// = SingleChromeWebDriverHelper.getInstance(false).getDriver();

    @Before
    public void testSetUp() {
      driver = SingleChromeWebDriverHelper.getInstance(true).getDriver();
    }
    
    @After 
    public void testShutDown() throws Exception {
      Thread.sleep(3000);
      driver.quit();
    }
    
    @Given("^I am on the BSIS login page$")
    public void i_am_on_the_BSIS_login_page() throws Throwable {
      driver.navigate().to(BSIS_LOGIN_PAGE);
      WebDriverWait wait = new WebDriverWait(driver, 15, 100);
      wait.until(AdditionalConditions.angularHasFinishedProcessing());
    }
    
    @When("^I populate the login form$")
    public void i_populate_the_login_form() throws Throwable {
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
      Assert.assertTrue("Not on home page",driver.getCurrentUrl().equals(BSIS_HOME_PAGE));
    }

    @Then("^I close the browser$")
    public void close_the_browser() throws Throwable {
      Thread.sleep(3000);
      driver.close();
    }

}
