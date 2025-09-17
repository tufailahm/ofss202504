Feature: Checking login functionality for parabank
  Scenario: validate login for valid user
    Given the user is on the login page of the website
    When user types username and password
    And user clicks on login button
    Then user should be navigated to customer dashboard page

