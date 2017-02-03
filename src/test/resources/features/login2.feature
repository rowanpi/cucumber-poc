Feature: Donor
  As a Donor Clinic Supervisor
  In order to add donors to the donor database
  I want to be able to successfully register a new donor

  Scenario: Login Superuser
    Given I am on the BSIS login page
    When I populate the login form with username "superuser" and password "superuser"
    And I click the login button
    Then I should be on the "HOME" page

  Scenario: Login Superuser and Navigate to settings
    Given I am on the BSIS login page
    When I populate the login form with username "superuser" and password "superuser"
    And I click the "login" button
    And I navigate to the "settings" page
    Then I should be on the "SETTINGS" page