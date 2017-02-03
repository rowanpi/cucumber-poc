Feature: Donor
  As a Donor Clinic Supervisor
  In order to add donors to the donor database
  I want to be able to successfully register a new donor

  Scenario: Search for Donor
    Given I am on the BSIS login page
    When I populate the login form with username "donorclinicstaff" and password "donorclinicstaff"
    And I click the "login" button
    And I navigate to the "find donor" page
    And I search for the donor with
      | Fields | Value  |
      | First  | Donald |
      | Last   | Trump  |
    And I click the "donor search" button
    Then I should find 0 donors

  Scenario: Search for Donor
    Given I am on the BSIS login page
    When I populate the login form with username "donorclinicstaff" and password "donorclinicstaff"
    And I click the "login" button
    And I navigate to the "find donor" page
    And I search for the donor with
      | Fields | Value  |
      | First  | Donald |
      | Last   | Trump  |
    And I click the "donor search" button
    Then I should find 0 donors
    And I click the "Add New Donor" link
    And I add a donor with
      | Fields   | Value   |
      | Title    | Mr      |
      | First    | Donald  |
      | Last     | Trump   |
      | Day      |      14 |
      | Month    | June    |
      | Year     |    1966 |
      | Gender   | Male    |
      | Venue    | Abuja   |
      | Language | English |
    And I click the "Add Donor" button
    Then I should see "Donald" "Trump" added as a new "Eligible donor"
