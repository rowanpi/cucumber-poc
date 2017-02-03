package org.jembi.cucumber.example.steps;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DonorSteps {
    public static final String XPATH_ADD_NEW_DONOR_LINK = "//*[@id=\"wrap\"]/div/div[2]/div/div[2]/div/div/p/span/em/a";
 
    private WebDriver driver = SingleChromeWebDriverHelper.getInstance(false).getDriver();
    
    @When("^I search for the donor with$")
    public void i_search_for_the_donor_with(DataTable table) throws Throwable {
      Map<String, String> data = table.asMap(String.class, String.class);
      driver.findElement(By.id("firstName")).sendKeys(data.get("First"));
      driver.findElement(By.id("lastName")).sendKeys(data.get("Last"));
    }

    @When("^I add a donor with$")
    public void i_add_a_donor_with(DataTable table) throws Throwable {
      Map<String, String> data = table.asMap(String.class, String.class);
      driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/form/div[2]/div/div/select")).sendKeys(data.get("Title"));
      driver.findElement(By.id("day")).sendKeys(data.get("Day"));
      driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/form/div[3]/div/div/select")).sendKeys(data.get("Month"));
      driver.findElement(By.id("year")).sendKeys(data.get("Year"));
      driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/form/div[4]/div/div/select")).sendKeys(data.get("Gender"));
      driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/form/div[5]/div/div/select")).sendKeys(data.get("Venue"));
      driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/form/div[6]/div/div/select")).sendKeys(data.get("Language"));
    }

    @Then("^I should find (\\d+) donors$")
    public void i_should_find_donors(int donors) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertTrue("Expected " + donors + " donors", driver.getPageSource().contains(donors +" donor(s) found"));
    }
    
    @Then("^I should see \"(.*?)\" \"(.*?)\" added as a new \"(.*?)\"$")
    public void i_should_see_as_an(String arg1, String arg2, String arg3) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
      Assert.assertTrue("donor not added sucessfully", driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/form/span[1]/span[1]")).getText().contains(arg1));
      Assert.assertTrue("donor not added sucessfully", driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/form/span[1]/span[3]")).getText().contains(arg2));
      Assert.assertTrue("donor not added sucessfully", driver.findElement(By.xpath("//*[@id=\"wrap\"]/div/div[2]/form/span[3]/div[2]/div/span")).getText().contains(arg3));
    }


}
