Feature: Donor
  As a Donor Clinic Supervisor
  In order to add donors to the donor database
  I want to be able to successfully register a new donor

  Scenario Outline: Login Superuser and Navigate to Page
    Given I am on the BSIS login page
    When I populate the login form with username "superuser" and password "superuser"
    And I click the "login" button
    And I click the "<Link>" link
    Then I should be on the "<Page>" page

    Examples: 
      | Link       | Page       |
      | settings   | SETTINGS   |
      | donors     | DONORS     |
      | components | COMPONENTS |
