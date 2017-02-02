Feature: Login
  As a superuser
  In order to access the BSIS app
  I want to be able to successfully login to BSIS

  Scenario: Login Superuser
    Given I open the chrome browser and navigate to the BSIS login page
    When I populate the login form
    And I click the login button
    Then I should be on the home page
    And I close the browser