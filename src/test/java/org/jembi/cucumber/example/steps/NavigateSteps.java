package org.jembi.cucumber.example.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//the only reason for this class file is for demoing parameters. 
public class NavigateSteps {

    private static final String BSIS_LOGIN_PAGE_URL = "http://127.0.0.1:9000/#/login";
    private static final String BSIS_HOME_PAGE_URL = "http://127.0.0.1:9000/#/home";
    private static final String BSIS_SETTINGS_PAGE_URL = "http://127.0.0.1:9000/#/accountSettings";
    private static final String BSIS_FIND_DONOR_PAGE_URL = "http://127.0.0.1:9000/#/findDonor";

    private Map<String, String> urlMap = ImmutableMap.of(
        "login", BSIS_LOGIN_PAGE_URL,
        "home", BSIS_HOME_PAGE_URL,
        "settings", BSIS_SETTINGS_PAGE_URL,
        "find donor", BSIS_FIND_DONOR_PAGE_URL);

    private static final String XPATH_BSIS_SETTINGS_PAGE_LINK = "//*[@id=\"settingsSection\"]";
    private static final String XPATH_BSIS_DONORS_PAGE_LINK =  "//*[@id=\"donorsSection\"]";
    private static final String XPATH_BSIS_COMPONENTS_PAGE_LINK = "//*[@id=\"componentsSection\"]";
    
    private Map<String, String> linksXPATHMap = ImmutableMap.of(
        "SETTINGS", XPATH_BSIS_SETTINGS_PAGE_LINK,
        "DONORS", XPATH_BSIS_DONORS_PAGE_LINK,
        "COMPONENTS", XPATH_BSIS_COMPONENTS_PAGE_LINK,
        "ADD NEW DONOR", DonorSteps.XPATH_ADD_NEW_DONOR_LINK);
    
    private static final String XPATH_SEARCH_BUTTON = "//*[@id=\"wrap\"]/div/div[2]/form/div[7]/div/button[1]";
    private static final String XPATH_LOGIN_BUTTON = "//*[@id=\"wrap\"]/div/div[1]/form/button";
    private static final String XPATH_ADD_DONOR_BUTTON = "//*[@id=\"wrap\"]/div/div[2]/form/div[7]/div/button";
    private Map<String, String> buttonXPATHMap = ImmutableMap.of(
        "LOGIN", XPATH_LOGIN_BUTTON,
        "DONOR SEARCH", XPATH_SEARCH_BUTTON,
        "ADD DONOR", XPATH_ADD_DONOR_BUTTON);
    
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

    @When("^I click the \"(.*?)\" button$")
    public void i_click_the_button(String button) throws Throwable {
      driver.findElement(By.xpath(buttonXPATHMap.get(button.toUpperCase()))).click();
      WebDriverWait wait = new WebDriverWait(driver, 15, 100);
      wait.until(AdditionalConditions.angularHasFinishedProcessing());
    }

    @When("^I click the \"(.*?)\" link$")
    public void i_click_the_link(String link) throws Throwable {
      driver.findElement(By.xpath(linksXPATHMap.get(link.toUpperCase()))).click();
      WebDriverWait wait = new WebDriverWait(driver, 15, 100);
      wait.until(AdditionalConditions.angularHasFinishedProcessing());
    }

    @Then("^I should be on the \"(.*?)\" page$")
    public void i_should_be_on_the_page(String page) throws Throwable {
      assertThat(driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).getText().trim(), is(page));
      //Assert.assertTrue("Not on " + page + " page",driver.getCurrentUrl().equals(urlMap.get(page.toLowerCase())));
    }
}
