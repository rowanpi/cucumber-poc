package org.jembi.cucumber.example.steps;

import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import org.junit.Assert;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps2 {

    private static final String BSIS_LOGIN_PAGE_URL = "http://127.0.0.1:9000/#/login";
    private static final String BSIS_HOME_PAGE_URL = "http://127.0.0.1:9000/#/home";
    private static final String BSIS_SETTINGS_PAGE_URL = "http://127.0.0.1:9000/#/accountSettings";
    private static final String BSIS_FIND_DONOR_PAGE_URL = "http://127.0.0.1:9000/#/findDonor";

    private Map<String, String> urlMap = ImmutableMap.of(
        "login", BSIS_LOGIN_PAGE_URL,
        "home", BSIS_HOME_PAGE_URL,
        "settings", BSIS_SETTINGS_PAGE_URL,
        "find donor", BSIS_FIND_DONOR_PAGE_URL);

    private WebDriver driver = SingleChromeWebDriverHelper.getInstance(false).getDriver();
    
    @Given("^I navigate to the \"(.*?)\" page$")
    public void i_navigate_to_the_page(String page) throws Throwable {
      driver.navigate().to(urlMap.get(page));
      WebDriverWait wait = new WebDriverWait(driver, 15, 100);
      wait.until(AdditionalConditions.angularHasFinishedProcessing());
    }

    @When("^I populate the login form with username \"(.*?)\" and password \"(.*?)\"$")
    public void i_populate_the_login_form_with_username_and_password(String username, String password) throws Throwable {
      driver.findElement(By.name("username")).sendKeys(username);
      driver.findElement(By.name("password")).sendKeys(password);
    }

/*    @When("^I click the login button$")
    public void i_click_login_the_login_button() throws Throwable {
      driver.findElement(By.className("btn")).click();
      WebDriverWait wait = new WebDriverWait(driver, 15, 100);
      wait.until(AdditionalConditions.angularHasFinishedProcessing());
    }
*/
    @Then("^I should be on the \"(.*?)\" page$")
    public void i_should_be_on_the_page(String page) throws Throwable {
      Assert.assertTrue("Not on home page",driver.getCurrentUrl().equals(urlMap.get(page.toLowerCase())));
    }
}
